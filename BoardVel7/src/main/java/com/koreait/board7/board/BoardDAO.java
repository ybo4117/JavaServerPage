package com.koreait.board7.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board7.DBUtils;

public class BoardDAO {

	public static int selPagingCnt(BoardDTO param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT CEIL(COUNT(iboard) / ?) as cnt ")
		.append("FROM t_board A ")
		.append("INNER JOIN t_user B ")
		.append(" ON A.i_user = B.i_user ");

		if (param.getSearchType() > 0) {
			sb.append("WHERE ");
		}

		switch (param.getSearchType()) {
		case 1: // 제목+내용
			sb.append("A.title LIKE '%")
			.append(param.getSearchText())
			.append("%' OR A.ctnt LIKE '%")
			.append(param.getSearchText())
			.append("%' ");

			break;
		case 2:// 제목
			sb.append("A.title LIKE '%").append(param.getSearchText()).append("%' ");
			break;
		case 3:// 내용
			sb.append("A.ctnt LIKE '%").append(param.getSearchText()).append("%' ");
			break;
		case 4:// 글쓴이
			sb.append("B.u_nm LIKE '%").append(param.getSearchText()).append("%' ");
			break;
		}

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sb.toString());
			ps.setInt(1, param.getRecordCnt());
			rs = ps.executeQuery();

			if (rs.next()) {
				// result = rs.getInt(1); 컬럼이 하나밖에없어서 이런식으로 첫번째를 가져와도 상관은 없다
				result = rs.getInt("cnt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return result;
	}

	public static List<BoardDomain> selBoardList(BoardDTO param) {
		List<BoardDomain> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT A.iboard, A.title, A.regdt, A.i_user,B.u_nm as writerNm FROM t_board A LEFT JOIN t_user B ON A.i_user = B.i_user";

		switch(param.getSearchType()) {
		case 1: // 제목+내용
			sql += String.format(" WHERE A.title LIKE '%%%s%%' OR A.ctnt LIKE '%%%s%%' ", param.getSearchText(), param.getSearchText());
			break;
		case 2:// 제목
			sql += String.format(" WHERE A.title LIKE '%%%s%%' ", param.getSearchText());
			break;
		case 3:// 내용
			sql += String.format(" WHERE A.ctnt LIKE '%%%s%%' ", param.getSearchText());
			break;
		case 4:// 글쓴이
			sql += String.format(" WHERE B.u_nm LIKE '%%%s%%' ",param.getSearchText());
			break;
		}		
		 sql += " ORDER BY iboard DESC LIMIT ?, ?";		

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getStartIdx());
			ps.setInt(2, param.getRecordCnt());
			rs = ps.executeQuery();

			while (rs.next()) {
				BoardDomain vo = new BoardDomain();
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIuser(rs.getInt("i_user"));
				vo.setWriterNm(rs.getString("writerNm"));

				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}

		return list;		
	}
	
	
	public static BoardDomain SelBoard(BoardDTO param) {
		BoardDomain result = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT A.title, A.regdt, A.i_user, A.ctnt, B.u_nm AS writerNm FROM t_board A LEFT JOIN t_user B ON A.i_user = B.i_user WHERE A.iboard = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = new BoardDomain();
				result.setIboard(param.getIboard());
				result.setTitle(rs.getString("title"));
				result.setCtnt(rs.getString("ctnt"));
				result.setIuser(rs.getInt("i_user"));
				result.setWriterNm(rs.getString("writerNm"));
				result.setRegdt(rs.getString("regdt"));				
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return result;
	}
}




