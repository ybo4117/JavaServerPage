package com.koreait.board5.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;

@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (MyUtils.getLoginUser("loginUser", request) == null) {
			response.sendRedirect("/user/userLogin");
			return;
		}

		List<BoardVO> list = BoardDAO.selBoardList();
		request.setAttribute("list", list);

		MyUtils.openJSP("board/list", request, response);
	}

}
