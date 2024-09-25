package vote.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vote.dao.VoteDao;
import vote.vo.VoteVO;

public class VoteCheckCommand implements VoteCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		VoteDao dao = new VoteDao();
		ArrayList<VoteVO> voteList = dao.voteList();
		
		request.setAttribute("voteList", voteList);
	}

}
