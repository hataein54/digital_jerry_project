package golf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import golf.vo.MemberVO;
import golf.vo.ResultVO;
import golf.vo.TeacherVO;

public class GolfDao {

	private DataSource dataSource = null;

	public GolfDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<TeacherVO> teacherList() {
		ArrayList<TeacherVO> teacherList = new ArrayList<TeacherVO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "select * from tbl_teacher";

		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				String teacher_code = resultSet.getString("teacher_code");
				String teacher_name = resultSet.getString("teacher_name");
				String class_name = resultSet.getString("class_name");
				int class_price = resultSet.getInt("class_price");
				String teacher_resist_date = resultSet.getString("teacher_resist_date");

				TeacherVO teacher = new TeacherVO(teacher_code, teacher_name, class_name, class_price,
						teacher_resist_date);

				teacherList.add(teacher);
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

		return teacherList;
	}

	public void insert(String resist_month, String c_no, String class_name, String class_area, String teacher_code) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String sql = "INSERT INTO tbl_class (resist_month, c_no, class_name, class_area, teacher_code) VALUES (?, ?, ?, ?, ?)";

		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, resist_month);
			preparedStatement.setString(2, c_no);
			preparedStatement.setString(3, class_name);
			preparedStatement.setString(4, class_area);
			preparedStatement.setString(5, teacher_code);

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

	public ArrayList<MemberVO> memberList() {
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "select * from tbl_member";

		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				String c_no = resultSet.getString("c_no");
				String c_name = resultSet.getString("c_name");
				String phone = resultSet.getString("phone");
				String address = resultSet.getString("address");
				String grade = resultSet.getString("grade");

				MemberVO member = new MemberVO(c_no, c_name, phone, address,
						grade);

				memberList.add(member);
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

		return memberList;
	}
	
	public ArrayList<ResultVO> resultList() {
		ArrayList<ResultVO> resultList = new ArrayList<ResultVO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "select t.teacher_code, t.class_name, t.teacher_name, t.class_price, count(c.c_no) as count from tbl_teacher t, tbl_class c where t.teacher_code = c.teacher_code group by t.teacher_code, t.class_name, t.teacher_name, t.class_price order by t.teacher_code";

		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				String teacher_code = resultSet.getString("teacher_code");
				String class_name = resultSet.getString("class_name");
				String teacher_name = resultSet.getString("teacher_name");
				int class_price = resultSet.getInt("class_price");
				int count = resultSet.getInt("count");
				
				int total = class_price * count;

				ResultVO result = new ResultVO(teacher_code, class_name, teacher_name, total);

				resultList.add(result);
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

		return resultList;
	}

}
