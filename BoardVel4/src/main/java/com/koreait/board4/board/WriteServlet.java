package com.koreait.board4.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.UserVO;

@WebServlet("/board/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
		if(loginUser == null) {
			response.sendRedirect("/user/login");
			return;
		}
		MyUtils.openJSP("/board/write", request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title"); // 제목
		String ctnt = request.getParameter("ctnt"); // 내용
		
//		HttpSession hs = request.getSession(); 
//		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");		
//		int iuser = loginUser.getIuser(); 
		// 글쓴이의 pk값 받아오기
		// 서버 세션저장되어있는 i_user의 값을 받아와야 안전하다. <jsp에 메모리값으로 보내면 문제가 생길 수 있다.>
		
		int iuser = MyUtils.getLoginUserPk(request);
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		vo.setIuser(iuser);
		
		BoardDAO.insBoard(vo);
		
		response.sendRedirect("list");
		
		
	}

}
