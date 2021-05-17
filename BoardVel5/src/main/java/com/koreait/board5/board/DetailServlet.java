package com.koreait.board5.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;
import com.koreait.board5.cmt.CmtDAO;

@WebServlet("/board/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (MyUtils.getLoginUser("loginUser", request) == null) {
			response.sendRedirect("/user/userLogin");
			return;
		}
		
		int iboard = MyUtils.getParamInt("iboard", request);
		request.setAttribute("data", BoardDAO.selBoard(iboard));

		request.setAttribute("Cmtlist", CmtDAO.selCmtList(iboard));
		MyUtils.openJSP("board/detail", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
