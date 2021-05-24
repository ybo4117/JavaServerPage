package com.koreait.board7;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board7.user.UserEntity;

public class MyUtils {
	public static void errMsg(String errMsgName, String errMsg, HttpServletRequest request) {
		if (request == null) {
			return;
		}
		request.setAttribute(errMsgName, errMsg);
	}

	public static int getLoginUserPk(String sesNm, HttpServletRequest request) {
		if (request == null) {
			return 0;
		}
		return getLoginUser(sesNm, request).getIuser();
	}

	public static UserEntity getLoginUser(String sesNm, HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		HttpSession hs = request.getSession();
		return (UserEntity) hs.getAttribute(sesNm);
	}

	public static int getParamInt(String key, HttpServletRequest request) {
		return parseStringToInt(request.getParameter(key));
	}

	public static int parseStringToInt(String val) {
		try {
			return Integer.parseInt(val);
		} catch (Exception e) {
			return 0;
		}
	}

	public static void openJSP(String title, String jsp, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", title);
		request.setAttribute("jsp", jsp);		
		request.getRequestDispatcher("/WEB-INF/view/template.jsp").forward(request, response);

	}

}
