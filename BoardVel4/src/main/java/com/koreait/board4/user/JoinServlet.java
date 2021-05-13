package com.koreait.board4.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board4.MyUtils;

@WebServlet("/user/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MyUtils.openJSP("user/join", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String u_id = request.getParameter("u_id");
		String u_pw = request.getParameter("u_pw");
		String u_nm = request.getParameter("u_nm");
		int gender = MyUtils.getParamInt("gender", request);

		String hashedUpw = BCrypt.hashpw(u_pw, BCrypt.gensalt());
		System.out.println("hashedUpw : " + hashedUpw);
		
		UserVO u_vo = new UserVO();
		u_vo.setUid(u_id);
		u_vo.setUpw(hashedUpw);
		u_vo.setUnm(u_nm);
		u_vo.setGender(gender);
		
		boolean result = UserDAO.checkId(u_vo);
		System.out.println("result : " + result);
		String errMsg = null;		
		
		if(u_id.isEmpty()) {
			MyUtils.errMsg("errMsg", "아이디를 입력해주세요", request);
			doGet(request, response);
			return;
		} else if(u_pw.isEmpty()) {
			MyUtils.errMsg("errMsg", "비밀번호를 입력해주세요.", request);			
			doGet(request, response);
			return;
		} else if(u_nm.isEmpty()){
			MyUtils.errMsg("errMsg", "이름을 입력해주세요", request);
			doGet(request, response);
			return;
		}
		
		if (result) { // 중복된 아이디값이 있을때
			errMsg = "중복된 아이디입니다.";
			request.setAttribute("errMsg", errMsg);
			doGet(request, response);
			return;
		}

		UserDAO.joinUser(u_vo);
		response.sendRedirect("login");
	}

}
