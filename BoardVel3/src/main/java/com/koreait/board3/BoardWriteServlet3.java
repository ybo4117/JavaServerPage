package com.koreait.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/write3")
public class BoardWriteServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "WEB-INF/view/write3.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("write_title");
		String ctnt = request.getParameter("write_content");
		
		System.out.println("제목 : " + title);
		System.out.println("내용 : " + ctnt);
		
		BoardVO3 vo3 = new BoardVO3();
		vo3.setTitle(title);
		vo3.setCtnt(ctnt);
		
		BoardDAO.insertBoard(vo3);	
		
		
		response.sendRedirect("/list3");
	}

}
