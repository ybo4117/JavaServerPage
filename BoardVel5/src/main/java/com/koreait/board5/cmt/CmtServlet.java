package com.koreait.board5.cmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;

@WebServlet("/board/cmt")
public class CmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int iuser = MyUtils.getLoginUserPk("loginUser", request);
		int icmt = MyUtils.getParamInt("icmt", request);
		int iboard = MyUtils.getParamInt("iboard", request);

		CmtVO param = new CmtVO();
		param.setIcmt(icmt);
		param.setIuser(iuser);

		CmtDAO.delCmt(param);

		response.sendRedirect("detail?iboard=" + iboard);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		int icmt = MyUtils.getParamInt("icmt", request);
		String cmt = request.getParameter("cmt");

		CmtVO param = new CmtVO();
		param.setCmt(cmt);
		param.setIuser(MyUtils.getLoginUserPk("loginUser", request));

		if (icmt != 0) {
			param.setIcmt(icmt);
			CmtDAO.updCmt(param);
			// 수정
		} else {
			param.setIboard(iboard);
			CmtDAO.insCmt(param);
			// 등록
		}

		response.sendRedirect("detail?iboard=" + iboard);
	}

}
