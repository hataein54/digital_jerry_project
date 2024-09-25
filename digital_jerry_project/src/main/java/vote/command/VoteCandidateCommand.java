package vote.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vote.dao.VoteDao;
import vote.vo.Candidate_plusTel_VO;

public class VoteCandidateCommand implements VoteCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		VoteDao dao = new VoteDao();
		ArrayList<Candidate_plusTel_VO> candidateList = dao.candidateList();
		
		request.setAttribute("candidateList", candidateList);
	}

}
