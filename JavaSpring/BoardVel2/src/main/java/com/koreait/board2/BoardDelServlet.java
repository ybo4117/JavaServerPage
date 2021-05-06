package com.koreait.board2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board2.Database;

@WebServlet("/del")
public class BoardDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("bbb");
										// detail.jsp의 input 타입에 있는 name = bbb 가 들어감
										// 이녀석은 detail.jsp의 value값인 ${param.aaa}가들어가
		BoardVO vo = (BoardVO)Database.db.get(Integer.parseInt(no));	
		
		Database.db.remove(vo);
		
		
		response.sendRedirect("/list");

	}

}
