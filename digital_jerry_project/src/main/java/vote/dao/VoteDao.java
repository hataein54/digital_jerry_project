package vote.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import vote.vo.Candidate_plusTel_VO;
import vote.vo.PartyVO;
import vote.vo.RankVO;
import vote.vo.VoteVO;

public class VoteDao {

	private DataSource dataSource = null;

	public VoteDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Candidate_plusTel_VO> candidateList() {
		ArrayList<Candidate_plusTel_VO> candidateList = new ArrayList<Candidate_plusTel_VO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "select m_no, m_name, party.p_name as p_name, p_school, m_jumin, m_city, p_tel1, p_tel2, p_tel3, p_code from candidate, party where candidate.p_name = party.p_name";

		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				String m_no = resultSet.getString("m_no");
				String m_name = resultSet.getString("m_name");
				String p_name = resultSet.getString("p_name");
				String p_school = resultSet.getString("p_school");
				String m_jumin = resultSet.getString("m_jumin");
				String m_city = resultSet.getString("m_city");
				String p_tel1 = resultSet.getString("p_tel1");
				String p_tel2 = resultSet.getString("p_tel2");
				String p_tel3 = resultSet.getString("p_tel3");
				String p_code = resultSet.getString("p_code");

				Candidate_plusTel_VO candidate = new Candidate_plusTel_VO(m_no, m_name, p_name, p_school, m_jumin,
						m_city, p_tel1, p_tel2, p_tel3, p_code);

				candidateList.add(candidate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {

			}
		}

		return candidateList;

	}

	public PartyVO getParty(String my_p_code) {
		PartyVO party = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "select * from party where p_code = ?";

		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, my_p_code);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String p_code = resultSet.getString("p_code");
				String p_name = resultSet.getString("p_name");
				Timestamp p_indate = resultSet.getTimestamp("p_indate");
				String p_reader = resultSet.getString("p_reader");
				String p_tel1 = resultSet.getString("p_tel1");
				String p_tel2 = resultSet.getString("p_tel2");
				String p_tel3 = resultSet.getString("p_tel3");

				party = new PartyVO(p_code, p_name, p_indate, p_reader, p_tel1, p_tel2, p_tel3);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {

			}
		}

		return party;
	}

	public void vote(String v_jumin, String v_name, String m_no, String v_time, String v_area, String v_confirm) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String sql = "INSERT INTO vote (v_jumin, v_name, m_no, v_time, v_area, v_confirm) VALUES (?, ?, ?, ?, ?, ?)";

		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, v_jumin);
			preparedStatement.setString(2, v_name);
			preparedStatement.setString(3, m_no);
			preparedStatement.setString(4, v_time);
			preparedStatement.setString(5, v_area);
			preparedStatement.setString(6, v_confirm);

			// delete update insert
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {

			}
		}

	}

	public ArrayList<VoteVO> voteList() {
		ArrayList<VoteVO> voteList = new ArrayList<VoteVO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		//DateTimeFormatter birthdayFormatter = DateTimeFormatter.ofPattern("yyMMdd");
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");

		String sql = "select * from vote where v_area like '%제1투표장%'";

		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String v_name = resultSet.getString("v_name");
				String birthday = resultSet.getString("v_jumin").substring(0, 6);

				LocalDate birthDate;
				
				try {
					// 생년월일 처리
					int year = Integer.parseInt(birthday.substring(0, 2));
					int month = Integer.parseInt(birthday.substring(2, 4));
					int day = Integer.parseInt(birthday.substring(4, 6));
					
					year = year >= 0 && year <= 21 ? year + 2000 : year + 1900;

					birthDate = LocalDate.of(year, month, day);
					
				} catch (DateTimeParseException | NumberFormatException e) {
					e.printStackTrace();
					continue;
				}
				
				LocalDate now = LocalDate.now();
				
				String age = String.valueOf(Period.between(birthDate, now).getYears());
				String gender = resultSet.getString("v_jumin").length() > 6 && resultSet.getString("v_jumin").charAt(6) == '1' || resultSet.getString("v_jumin").charAt(6) == '3' ? "남" : "여";
				String v_time = resultSet.getString("v_time").substring(0, 2) + ":" + resultSet.getString("v_time").substring(2, 4);

				String v_confirm = resultSet.getString("v_confirm");

				if (v_confirm.equals("1")) {
					v_confirm = "확인";
				} else {
					v_confirm = "미확인";
				}

				VoteVO vote = new VoteVO(v_name, birthDate.format(outputFormatter), age, gender, resultSet.getString("m_no"), v_time, v_confirm);

				voteList.add(vote);
				
				System.out.println(vote.getV_name());
				System.out.println(vote.getBirthDay());
				System.out.println(vote.getAge());
				System.out.println(vote.getGender());
				System.out.println(vote.getM_no());
				System.out.println(vote.getV_time());
				System.out.println(vote.getV_confirm());

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				if (resultSet != null)
					resultSet.close();

				if (preparedStatement != null)
					preparedStatement.close();

				if (connection != null)
					connection.close();

			} catch (Exception e2) {

			}

		}

		return voteList;
	}

	public ArrayList<RankVO> rankList() {
		ArrayList<RankVO> rankList = new ArrayList<RankVO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "select c.m_no, m_name, count(v.M_NO) as count from candidate c, VOTE v where c.m_no = v.m_no group by c.m_no, m_name order by count(v.m_no) desc";

		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				String m_no = resultSet.getString("m_no");
				String m_name = resultSet.getString("m_name");
				int count = resultSet.getInt("count");

				RankVO rank = new RankVO(m_no, m_name, count);

				rankList.add(rank);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {

			}
		}

		return rankList;
	}

}
