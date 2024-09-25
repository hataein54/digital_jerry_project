package homeshopping.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homeshopping.dao.homeShopping_Dao;

public class homeShoppingDeleteCommand implements homeShoppingCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String custno = request.getParameter("custno");
		
		homeShopping_Dao dao = new homeShopping_Dao();
		dao.deleteBoard(custno);
	}

}
