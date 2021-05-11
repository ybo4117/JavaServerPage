package com.koreait.board4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtils {
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

	public static void openJSP(String fileNm, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		fileNm = "/WEB-INF/view-jsp/" + fileNm + ".jsp";		
		request.getRequestDispatcher(fileNm).forward(request, response);
		
	}
}
