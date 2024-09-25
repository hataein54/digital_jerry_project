package golf.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import golf.dao.GolfDao;

public class GolfInsertCommand implements GolfCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String resist_month = request.getParameter("resist_month");
		String c_no = request.getParameter("c_no");
		String class_name = request.getParameter("class_name");
		String class_area = request.getParameter("class_area");
		String teacher_code = request.getParameter("teacher_code");
		
		
		GolfDao dao = new GolfDao();
		
		dao.insert(resist_month, c_no, class_name, class_area, teacher_code);
	}

}
