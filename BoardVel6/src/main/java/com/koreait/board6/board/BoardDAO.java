package com.koreait.board6.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board6.DBUtils;
import com.koreait.board6.board.BoardVO;

public class BoardDAO {
	public static int getALLpage(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT ceil(COUNT(*) / ?) as cnt FROM t_board";

		int result = 0;
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getPage());

			rs = ps.executeQuery();

			if (rs.next()) {
				result = rs.getInt("cnt");
				//result = rs.getInt(1); 이렇게 써도됨
			}

		} catch (Exception e) {
			e.printStackTrace();			
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return result;
	}

	public static List<BoardVO> selBoardList(BoardVO param) {
		List<BoardVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT A.iboard, A.title, A.regdt, B.u_nm FROM t_board A LEFT JOIN t_user B ON A.i_user = B.i_user ORDER BY iboard DESC LIMIT ?, ?";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getsIdx());
			ps.setInt(2, param.getPage());

			rs = ps.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setUnm(rs.getString("u_nm"));

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
