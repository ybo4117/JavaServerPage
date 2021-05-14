package com.koreait.board5.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board5.MyUtils;

@WebServlet("/user/userJoin")
public class UserJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MyUtils.openJSP("user/userJoin", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_id = request.getParameter("u_id");
		String u_pw = request.getParameter("u_pw");
		String u_nm = request.getParameter("u_nm");
		int gender = MyUtils.getParamInt("gender", request);
		
		String hashedUpw = BCrypt.hashpw(u_pw, BCrypt.gensalt());
		
		
		UserVO param = new UserVO();
		param.setUid(u_id);
		param.setUpw(hashedUpw);
		param.setUnm(u_nm);
		param.setGender(gender);
		
		UserDAO.insUser(param);
		
		response.sendRedirect("userLogin");		
		
	}

}
