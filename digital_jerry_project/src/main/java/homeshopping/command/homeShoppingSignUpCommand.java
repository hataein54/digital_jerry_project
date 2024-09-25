package homeshopping.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homeshopping.dao.homeShopping_Dao;

public class homeShoppingSignUpCommand implements homeShoppingCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		
		homeShopping_Dao dao = new homeShopping_Dao();

		dao.signUp(custname, phone, address, grade, city);
	}

}
