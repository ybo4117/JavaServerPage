package com.koreait.board7.cmt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.koreait.board7.MyUtils;

@WebServlet("/board/cmtInsSel")
public class BoardCmtInsSelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//리스트
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		System.out.println("iboard : " + iboard);
		
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIboard(iboard);
		
		List<BoardCmtDomain> list = BoardCmtDAO.selBoardCmtList(param);
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append(json);
		
	}

	//등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int iboard = MyUtils.getParamInt("iboard", request);
			String cmt = request.getParameter("cmt");
			int iuser = MyUtils.getLoginUserPk("loginUser", request);
			
			BoardCmtEntity param = new BoardCmtEntity();
			param.setIboard(iboard);
			param.setCmt(cmt);
			param.setIuser(iuser);
			
			int result = BoardCmtDAO.insBoardCmt(param);
			
			response.getWriter().append("{").append("\"result\":").append(String.valueOf(result)).append("}").flush();
			// 이녀석이 {"result":?} 이랑 같다 Json형태
			
			
	}

}
