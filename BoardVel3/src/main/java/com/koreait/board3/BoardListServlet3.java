package com.koreait.board3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list3")
public class BoardListServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		System.out.println(num);
		
		int intNum = 0;
		if(num != null) {
			intNum= Integer.parseInt(num);
		}
		// 보낼때 아예없는 값을 먼저 보내면 따로 받을수 있다
		List<BoardVO3> list = BoardDAO.selBoardList(intNum); // 아규먼트값이 없다는건 다보내겠다
		request.setAttribute("list", list);
		
		
		String jsp = "WEB-INF/view/list3.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
		// 연습중입니다
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
