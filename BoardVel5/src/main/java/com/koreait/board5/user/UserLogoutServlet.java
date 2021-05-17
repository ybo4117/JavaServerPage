package com.koreait.board5.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user/userLogout")
public class UserLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession();
		hs.invalidate(); // 세션에 있는 모든 값을 날린다
		
		response.sendRedirect("/user/userLogin");

		/*
		 * hs.setAttribute("loginUser", null); 
		 * 세션에 특정 부분만 삭제, 수정할 경우
		 * 
		 * hs.removeAttribute("");
		 * 세션을 삭제할 경우
		 */
	}

}
