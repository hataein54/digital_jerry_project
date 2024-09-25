package homeshopping.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homeshopping.dao.homeShopping_Dao;

public class homeShoppingModifyCommand implements homeShoppingCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String custno = request.getParameter("custno");
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		
		System.out.println(custno);
		System.out.println(custname);
		System.out.println(phone);
		System.out.println(address);
		System.out.println(grade);
		System.out.println(city);
		
		homeShopping_Dao dao = new homeShopping_Dao();
		
		dao.modify(custno, custname, phone, address, grade, city);
	}

}
