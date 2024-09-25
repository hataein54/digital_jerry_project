package golf.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import golf.dao.GolfDao;
import golf.vo.TeacherVO;

public class GolfTeacherCommand implements GolfCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		GolfDao dao = new GolfDao();
		ArrayList<TeacherVO> teacherList = dao.teacherList();
		
		request.setAttribute("teacherList", teacherList);
	}

}
