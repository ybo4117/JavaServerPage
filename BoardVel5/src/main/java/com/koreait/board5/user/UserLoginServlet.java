package com.koreait.board5.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board5.MyUtils;

@WebServlet("/user/userLogin")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (MyUtils.getLoginUser("loginUser", request) != null) {
			response.sendRedirect("/board/list");
			return;
		}
		MyUtils.openJSP("user/userLogin", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String u_id = request.getParameter("u_id");
		String u_pw = request.getParameter("u_pw");

		UserVO u_vo = new UserVO();
		u_vo.setUid(u_id);
		
		UserVO result = UserDAO.selUser(u_vo);
		if (result == null) { // 아이디가 없음			
//			request.setAttribute("errMsg", "아이디를 확인해 주세요.");
			MyUtils.errMsg("errMsg", "아이디를 확인해 주세요", request);
			
		} else if (BCrypt.checkpw(u_pw, result.getUpw())) { // 아이디가 있음 & 비밀번호 체크 성공 => 로그인 성공
			result.setUpw(null);
			HttpSession hs = request.getSession();
			hs.setAttribute("loginUser", result);
			response.sendRedirect("/board/list");			
			return;
			
		} else { // 비밀번호 틀림			
//			request.setAttribute("errMsg", "비밀번호를 확인해 주세요.");
			MyUtils.errMsg("errMsg", "비밀번호를 확인해 주세요.", request);
			
		}
		
		doGet(request, response);
		// 깃허브 연습
		
	}
}
