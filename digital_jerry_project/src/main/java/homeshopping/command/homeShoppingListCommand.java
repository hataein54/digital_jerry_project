package homeshopping.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homeshopping.dao.homeShopping_Dao;
import homeshopping.vo.member_info_VO;

public class homeShoppingListCommand implements homeShoppingCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		homeShopping_Dao dao = new homeShopping_Dao();
		ArrayList<member_info_VO> memberList = dao.memberList();
		request.setAttribute("memberList", memberList);
	}

}
