package com.koreait.board4.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
		if(loginUser != null) {
			response.sendRedirect("/board/list");
			return;
		}
		
		MyUtils.openJSP("user/login", request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String u_id = request.getParameter("u_id");
		String u_pw = request.getParameter("u_pw");

		UserVO u_vo = new UserVO();
		u_vo.setUid(u_id);
		u_vo.setUpw(u_pw);

		int result = UserDAO.loginUser(u_vo);
		System.out.println(result);
		
		if (result == 1) { // 로그인 성공
			HttpSession hs = request.getSession();
			u_vo.setUpw(null);
			hs.setAttribute("loginUser", u_vo);
			// u_vo가 가리키는 UserVo객체는 (iuser, u_id, u_nm값만 담고 있다.) 
			
			response.sendRedirect("/board/list");
			return;
		}
		String errMsg = null;
		switch (result) {
		case 0:
			errMsg = "에러가 발생하였습니다.";
			break;
		case 2:
			errMsg = "아이디를 확인해 주세요";
			break;
		case 3:
			errMsg = "비밀번호를 확인해 주세요.";
			break;
		}
		request.setAttribute("errMsg", errMsg);
		
		doGet(request, response);
		// response.sendRedirect("login");
	}

}
