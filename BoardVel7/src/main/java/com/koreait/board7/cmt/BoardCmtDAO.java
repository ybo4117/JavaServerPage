package com.koreait.board7.cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board7.DBUtils;

public class BoardCmtDAO {

	public static int insBoardCmt(BoardCmtEntity param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "INSERT INTO t_board_cmt (iboard, i_user, cmt) VALUES (?, ?, ?)";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());
			ps.setString(3, param.getCmt());

			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return result;
	}

	public static List<BoardCmtDomain> selBoardCmtList(BoardCmtEntity param) {
		List<BoardCmtDomain> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT A.icmt, A.cmt, A.regdate, B.i_user, B.u_nm AS writerNm FROM t_board_cmt A INNER JOIN t_user B ON A.i_user=B.i_user WHERE A.iboard = ?";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardCmtDomain vo = new BoardCmtDomain();
				vo.setIcmt(rs.getInt("icmt"));
				vo.setCmt(rs.getString("cmt"));
				vo.setRegdate(rs.getString("regdate"));
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

}