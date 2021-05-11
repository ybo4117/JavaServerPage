package com.koreait.board4.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;


@WebServlet("/user/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("user/join", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_id = request.getParameter("u_id");
		String u_pw = request.getParameter("u_pw");
		String u_nm = request.getParameter("u_nm");
		int gender = MyUtils.getParamInt("gender", request);
				
		UserVO u_vo = new UserVO();		
		u_vo.setUid(u_id);
		u_vo.setUpw(u_pw);
		u_vo.setUnm(u_nm);
		u_vo.setGender(gender);
		
		UserDAO.joinUser(u_vo);
		
		response.sendRedirect("login");		
	}

}
