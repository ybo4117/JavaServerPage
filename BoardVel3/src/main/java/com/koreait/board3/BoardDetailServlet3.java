package com.koreait.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/detail3")
public class BoardDetailServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");	
		BoardVO3 vo = new BoardVO3();
		
		int intIboard = Integer.parseInt(iboard);
		BoardVO3 data = BoardDAO.selBoard(intIboard);		
		request.setAttribute("data", data);		
		
		//TODO 조회수 처리시 이쪽에서 받아서 DAO보내주고 값을 받아서
		// setAttribute로 값을 저장해서 보낸다.
		
		
		String jsp = "WEB-INF/view/detail3.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
}