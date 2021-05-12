package com.koreait.board4.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board4.DBUtils;

public class BoardDAO {
	// update, insert, delete 는 리턴타입이 int이다
	// why? ==> sql문으로 받을 때 영향받은 행의 값이 숫자 그러니까 영향받은 행의 x 값이 무엇이냐 그것이 궁금하기에 리턴타입은
	// int이다
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
			return 0;
		} finally {
			DBUtils.close(con, ps);
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
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				String u_nm = rs.getString("u_nm");

				BoardVO vo = new BoardVO();
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
				vo.setUnm(u_nm);

				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
	}

	public static BoardVO selBoard(int iboard) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO data = null;

		String sql = "SELECT A.title, A.regdt, A.ctnt, A.i_user, B.u_nm FROM t_board A LEFT JOIN t_user B ON A.i_user = B.i_user WHERE iboard = ?";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs = ps.executeQuery();

			if (rs.next()) {
				data = new BoardVO();

				data.setIboard(iboard);
				data.setTitle(rs.getString("title"));
				data.setCtnt(rs.getString("ctnt"));
				data.setIuser(rs.getInt("i_user"));
				data.setRegdt(rs.getString("regdt"));
				data.setUnm(rs.getString("u_nm"));

			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtils.close(con, ps, rs);
		}
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
