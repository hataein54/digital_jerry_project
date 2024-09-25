package vote.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vote.command.VoteCandidateCommand;
import vote.command.VoteCheckCommand;
import vote.command.VoteCommand;
import vote.command.VoteInsertCommand;
import vote.command.VotePartyCommand;
import vote.command.VoteRankCommand;


@WebServlet("*.doVote")
public class VoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public VoteController() {
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
    	 VoteCommand  command = null;
    	 
    	 String uri = request.getRequestURI();
    	 String contextPath = request.getContextPath(); //프로젝트이름
    	 String com = uri.substring(contextPath.length());
    	 
    	 System.out.println(uri + "." + contextPath + "." + com);
    	 
    	 if(com.equals("/candidate_view.doVote")) {
    		 command = new VoteCandidateCommand();
    		 command.execute(request, response);
    		 viewPage = "candidate.jsp";
    	 } else if(com.equals("/party_view.doVote")) {
    		 command = new VotePartyCommand();
    		 command.execute(request, response);
    		 viewPage = "party.jsp";
    	 } else if(com.equals("/vote_view.doVote")) {
    		 viewPage = "vote.jsp";
    	 } else if(com.equals("/vote.doVote")) {
    		 command = new VoteInsertCommand();
    		 command.execute(request, response);
    		 viewPage = "voteMain.html";
    	 } else if(com.equals("/check_view.doVote")) {
    		 command = new VoteCheckCommand();
    		 command.execute(request, response);
    		 viewPage = "check.jsp";
    	 } else if(com.equals("/rank_view.doVote")) {
    		 command = new VoteRankCommand();
    		 command.execute(request, response);
    		 viewPage = "rank.jsp";
    	 }
    	 
    	 
    	RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
    	dispatcher.forward(request, response);
     }

  }

