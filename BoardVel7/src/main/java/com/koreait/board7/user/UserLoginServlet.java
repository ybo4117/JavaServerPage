package com.koreait.board7.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board7.MyUtils;
import com.koreait.board7.user.UserDAO;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MyUtils.openJSP("로그인", "user/userLogin", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");

		UserEntity u_vo = new UserEntity();
		u_vo.setUid(uid);

		UserEntity result = UserDAO.selUser(u_vo);
		if (result == null) { // 아이디가 없음
			MyUtils.errMsg("errMsg", "아이디를 확인해 주세요", request);

		} else if (BCrypt.checkpw(upw, result.getUpw())) { // 아이디가 있음 & 비밀번호 체크 성공 => 로그인 성공
			result.setUpw(null);
			HttpSession hs = request.getSession();
			hs.setAttribute("loginUser", result);
			response.sendRedirect("/board/list");
			return;

		} else { // 비밀번호 틀림
			MyUtils.errMsg("errMsg", "비밀번호를 확인해 주세요.", request);

		}

		doGet(request, response);

	}

}
