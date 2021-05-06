package com.koreait.board3;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/desc3")
public class BoardDescServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardVO3> list = BoardDAO.descBoard();	
		request.setAttribute("list", list);	
		
		String jsp = "WEB-INF/view/list3.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);	
	}	
}