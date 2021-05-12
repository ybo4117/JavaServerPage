package com.koreait.board4.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.board.BoardDAO;
import com.koreait.board4.board.BoardVO;
import com.koreait.board4.MyUtils;
import com.koreait.board4.user.UserVO;

@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
		
		//로그인 안되어있으면 로그인 화면으로 이동		
		if(loginUser == null) {
			response.sendRedirect("/user/login");
			return;
		}
		
		List<BoardVO> list = BoardDAO.selBoardList(); // 아규먼트값이 없다는건 다보내겠다
		request.setAttribute("list", list);
		
		
		//로그인 했으면 board/list.jsp응답		
		MyUtils.openJSP("board/list", request, response);		
			
		
		
		
//		Boolean loginSuccess = (Boolean)hs.getAttribute("loginSuccess");
//		System.out.println("loginSuccess : " + loginSuccess);
//		if(loginSuccess == null || loginSuccess == false) {
//			response.sendRedirect("/user/login");
//			return;
//		}
//		MyUtils.openJSP("board/list", request, response);
	}
}
