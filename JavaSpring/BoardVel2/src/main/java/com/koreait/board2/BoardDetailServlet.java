package com.koreait.board2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("aaa"); // 0번 : 첫번째 글, 1번 : 두번째 글
									// list.jsp에 있는 "/detail?aaa=${status.index}의 값이들어감"
		BoardVO vo = (BoardVO)Database.db.get(Integer.parseInt(no));
		
//		int intNo = Integer.parseInt(no);
//		
//		List<BoardVO> list = Database.db;
//		BoardVO vo = list.get(intNo);
//		BoardVO vo = list.get(Integer.parseInt(no));
//		BoardVO vo = (BoardVO)Database.db.get(Integer.parseInt(no));
		
		request.setAttribute("data", vo);
		request.setAttribute("num", 10);
		request.setAttribute("babo","바보");
		
		String jsp = "WEB-INF/jsp/detail.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

}
