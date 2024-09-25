package homeshopping.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homeshopping.dao.homeShopping_Dao;
import homeshopping.vo.member_info_VO;

public class homeShoppingModifyViewCommand implements homeShoppingCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String custno = request.getParameter("custno");
		
		homeShopping_Dao dao = new homeShopping_Dao();
		member_info_VO member = dao.getMember(custno);
		
		member.getAddress();
		request.setAttribute("member", member);
	}

}
