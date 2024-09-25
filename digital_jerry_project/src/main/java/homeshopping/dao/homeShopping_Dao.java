package homeshopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import homeshopping.vo.member_info_VO;
import homeshopping.vo.member_money_VO;


public class homeShopping_Dao {
	private DataSource dataSource = null;
	
	public homeShopping_Dao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void signUp(String custname, String phone, String address, String grade, String city) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String sql = "insert into member_info (custno, custname, phone, address, grade, city) values (custno_seq.nextval, ?, ?, ?, ?, ?)";
		
		try {
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, custname);
			preparedStatement.setString(2, phone);
			preparedStatement.setString(3, address);
			preparedStatement.setString(4, grade);
			preparedStatement.setString(5, city);
			
			preparedStatement.executeUpdate();			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			} catch (Exception e2) {
				
			}
		}
	}
	
	public ArrayList<member_info_VO> memberList(){
		ArrayList<member_info_VO> memberList = new ArrayList<member_info_VO>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "select * from member_info order by custno";
				
		try {
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
						
			while(resultSet.next()) {
				int custno = resultSet.getInt("custno");
				String custname = resultSet.getString("custname");
				String phone = resultSet.getString("phone");
				String address = resultSet.getString("address");
				Timestamp joindate = resultSet.getTimestamp("joindate");
				String grade = resultSet.getString("grade");
				String city = resultSet.getString("city");
				
				member_info_VO member = new member_info_VO(custno, custname, phone, address, joindate, grade, city);
				
				memberList.add(member);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null)
					resultSet.close();
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			} catch (Exception e2) {
				
			}
		}
		
		return memberList;
	}

	public member_info_VO getMember(String mycustno) {
		member_info_VO member = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		System.out.println(mycustno);
		
		String sql = "select * from member_info where custno = ?";
		
		try {
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, Integer.valueOf(mycustno));
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int custno = resultSet.getInt("custno");
				String custname = resultSet.getString("custname");
				String phone = resultSet.getString("phone");
				String address = resultSet.getString("address");
				Timestamp joindate = resultSet.getTimestamp("joindate");
				String grade = resultSet.getString("grade");
				String city = resultSet.getString("city");
				
				member = new member_info_VO(custno, custname, phone, address, joindate, grade, city);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null)
					resultSet.close();
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			} catch (Exception e2) {
				
			}
		}
		
		return member;
	}
	
	public void modify(String custno, String custname, String phone, String address, String grade, String city) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String sql = "update member_info set custname = ?, phone = ?, address = ?, grade = ?, city = ? where custno = ?";
		
		try {
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, custname);
			preparedStatement.setString(2, phone);
			preparedStatement.setString(3, address);
			preparedStatement.setString(4, grade);
			preparedStatement.setString(5, city);
			preparedStatement.setInt(6, Integer.valueOf(custno));
			
			preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			} catch (Exception e2) {
				
			}
		}		
	}

	public void deleteBoard(String custno) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String sql = "delete from member_info where custno = ?";
		
		try {
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, Integer.valueOf(custno));
			
			preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			} catch (Exception e2) {
				
			}
		}				
	}

	public ArrayList<member_money_VO> moneyList() {
		ArrayList<member_money_VO> moneyList = new ArrayList<member_money_VO>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "select m.custno, custname, grade, sum(price) as price from member_info i, member_money m where i.custno = m.custno group by m.custno, custname, grade order by price desc";
				
		try {
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
						
			while(resultSet.next()) {
				int custno = resultSet.getInt("custno");
				String custname = resultSet.getString("custname");
				String grade = resultSet.getString("grade");
				int price = resultSet.getInt("price");
				
				member_money_VO money = new member_money_VO(custno, custname, grade, price);
				
				moneyList.add(money);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null)
					resultSet.close();
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			} catch (Exception e2) {
				
			}
		}
		
		return moneyList;
	}
}
