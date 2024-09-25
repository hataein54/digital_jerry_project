package golf.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import golf.command.GolfCommand;
import golf.command.GolfInsertCommand;
import golf.command.GolfMemberCommand;
import golf.command.GolfResultCommand;
import golf.command.GolfTeacherCommand;


@WebServlet("*.doGolf")
public class GolfController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GolfController() {
        super();
       
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet..");
        actionDo(request, response);
        
     }


     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost..");
        actionDo(request, response);
        
     }
     
     private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 System.out.println("actionDo..");
    	 request.setCharacterEncoding("UTF-8");
    	 
    	 String viewPage = null;
    	 GolfCommand command = null;
    	 
    	 String uri = request.getRequestURI();
    	 String contextPath = request.getContextPath(); //프로젝트이름
    	 String com = uri.substring(contextPath.length());
    	 
    	 System.out.println(uri + "::" + contextPath + "::" + com);
    	 
    	 if(com.equals("/teacher_view.doGolf")) {
    		 command = new GolfTeacherCommand();
    		 command.execute(request, response);
    		 viewPage = "teacher.jsp";
    	 }
    	 
    	 else if(com.equals("/insert_view.doGolf")) {
    		 viewPage = "insert.jsp";
    	 }
    	 
    	 else if(com.equals("/insert.doGolf")) {
    		 command = new GolfInsertCommand();
    		 command.execute(request, response);
    		 viewPage = "index.html";
    	 }
    	 
    	 else if(com.equals("/member_view.doGolf")) {
    		 command = new GolfMemberCommand();
    		 command.execute(request, response);
    		 viewPage = "member.jsp";
    	 }
    	 
    	 else if(com.equals("/result_view.doGolf")) {
    		 command = new GolfResultCommand();
    		 command.execute(request, response);
    		 viewPage = "result.jsp";
    	 }
    	 
    	 
    	RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
    	dispatcher.forward(request, response);
     }

  }

