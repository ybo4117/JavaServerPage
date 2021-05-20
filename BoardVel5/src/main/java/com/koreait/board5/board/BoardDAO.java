package com.koreait.board5.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board5.DBUtils;

public class BoardDAO {

	public static int insBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "INSERT INTO t_board (title, ctnt, i_user) VALUES (?, ?, ?)";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIuser());

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}

		return 0;
	}

	public static BoardVO selBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO data = null;

		String sql = "SELECT A.iboard, A.title, A.ctnt, A.i_user, A.regdt,"
				+ " B.u_nm, if(C.iboard IS NULL, 0, 1) AS isFav"
				+ " FROM t_board A"
				+ " INNER JOIN t_user B"
				+ " ON A.i_user = B.i_user"
				
				+ " LEFT JOIN t_board_fav C"
				+ " ON A.iboard = C.iboard"
				+ " AND C.i_user = ? WHERE A.iboard = ?;";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIuser());
			ps.setInt(2, param.getIboard());
			rs = ps.executeQuery();

			if (rs.next()) {
				data = new BoardVO();

				data.setIboard(rs.getInt("iboard"));
				data.setTitle(rs.getString("title"));
				data.setCtnt(rs.getString("ctnt"));
				data.setIuser(rs.getInt("i_user"));
				data.setRegdt(rs.getString("regdt"));
				data.setUnm(rs.getString("u_nm"));
				data.setIsFav(rs.getInt("isFav"));

			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}

	public static List<BoardVO> selBoardList() {
		List<BoardVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT A.iboard, A.title, A.regdt, B.u_nm FROM t_board A LEFT JOIN t_user B ON A.i_user = B.i_user ORDER BY iboard DESC";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
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

	public static int delBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "DELETE FROM t_board WHERE iboard = ? AND i_user = ?";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());

			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}

	public static int updBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "UPDATE t_board SET title = ? , ctnt = ? WHERE i_user = ? AND iboard = ?";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIuser());
			ps.setInt(4, param.getIboard());

			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}

}
