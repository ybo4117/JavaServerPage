package com.koreait.board7.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/idChk")
public class IdChkAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		System.out.println(uid);
		int result = UserDAO.selIdChk(uid);
		
		response.getWriter().append("{\"result\":")
		.append(String.valueOf(result))
		.append("}")
		.close();
		/*
		PrintWriter pw = response.getWriter();
		pw.append("");
		이런식으로 써도된다
		*/
		
	}


}
