package com.koreait.board7.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDTO param = new BoardDTO();

		// 페이징
		final int recordCnt = 10;
		int cPage = MyUtils.getParamInt("cPage", request);
		if (cPage == 0) {
			cPage = 1;
		}
		int startIdx = (cPage - 1) * recordCnt;
		param.setRecordCnt(recordCnt);
		param.setStartIdx(startIdx);

		// 검색
		int searchType = MyUtils.getParamInt("searchType", request);
		String searchText = request.getParameter("searchText");

		if (searchType != 0 && searchText != null && !searchText.equals("")) {
			param.setSearchType(searchType);
			param.setSearchText(searchText);
		}
		
		request.setAttribute("list", BoardDAO.selBoardList(param));
		request.setAttribute("pagingCnt", BoardDAO.selPagingCnt(param));
		MyUtils.openJSP("리스트", "board/boardList", request, response);
	}

}
