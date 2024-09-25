package golf.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import golf.dao.GolfDao;
import golf.vo.ResultVO;
import golf.vo.TeacherVO;

public class GolfResultCommand implements GolfCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		GolfDao dao = new GolfDao();
		ArrayList<ResultVO> resultList = dao.resultList();
		
		request.setAttribute("resultList", resultList);
	}

}
