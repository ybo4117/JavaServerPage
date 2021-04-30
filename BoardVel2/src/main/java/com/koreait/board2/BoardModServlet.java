package com.koreait.board2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("ccc");		
									// /mod?ccc=${param.aaa}의 값이 들어간거
		request.setAttribute("data", Database.db.get(Integer.parseInt(no)));
		
		String jsp = "WEB-INF/jsp/mod.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("fff");
										// mod.jsp의 input name의 fff의 값인 value="${param.ccc}"이녀석이 들어간다.
		String title= request.getParameter("title");
		String ctnt=request.getParameter("ctnt");
		BoardVO vo = (BoardVO)Database.db.get(Integer.parseInt(no));
		
		vo.setTitle(title);
		vo.setCtnt(ctnt);		
		
		response.sendRedirect("/detail?aaa=" + no);
	}

}
