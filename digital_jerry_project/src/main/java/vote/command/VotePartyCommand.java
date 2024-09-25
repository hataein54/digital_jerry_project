package vote.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vote.dao.VoteDao;
import vote.vo.PartyVO;

public class VotePartyCommand implements VoteCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String p_code = request.getParameter("p_code");
		
		VoteDao dao = new VoteDao();
		PartyVO party = dao.getParty(p_code);
		
		request.setAttribute("party", party);
	}

}
