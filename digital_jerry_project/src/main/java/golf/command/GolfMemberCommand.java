package golf.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import golf.dao.GolfDao;
import golf.vo.MemberVO;

public class GolfMemberCommand implements GolfCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		GolfDao dao = new GolfDao();
		ArrayList<MemberVO> memberList = dao.memberList();
		
		request.setAttribute("memberList", memberList);
		System.out.println(memberList);
	}

}
