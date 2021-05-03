package com.koreait.board3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

// Data Access Object(DB 담당)
public class BoardDAO {

	// 글등록
	public static int insertBoard(BoardVO3 vo) {
		Connection con = null;
		PreparedStatement ps = null;

		// 물론 "~~~" 붙혀서 써도된다.
		// String sql = "INSERT INTO t_board" + "(title, ctnt)" + "(VALUES)" +
		// "('"+vo.getTitle()+"', '"+vo.getCtnt()+"')";
		String sql = "INSERT INTO t_board (title, ctnt) VALUES(? , ?)";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());

			return ps.executeUpdate(); // insert, update, delete

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
			// 서버를 닫아주지않으면 서버가 죽을확률이 높아진다
			// 이녀석그냥쓰세여 습관처럼 쓰세여 무조건 !!
		}

		return 0;
	}

	public static List<BoardVO3> selBoardList() {
		List<BoardVO3> a = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT iboard, title, regdt FROM t_board ORDER BY iboard DESC";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);						
			rs = ps.executeQuery(); // select 
//			for (int i = 0 ; rs.next() ; i++) {
//				BoardVO3 vo = new BoardVO3();				
//				vo.setIboard(rs.getInt("iboard"));
//				vo.setTitle(rs.getString("title"));
//				vo.setRegdt(rs.getString("regdt"));
//				a.add(vo);				
//			}
			
			while(rs.next()) {
				BoardVO3 vo = new BoardVO3();				
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
//				vo.setIboard(rs.getInt(1));
//				vo.setTitle(rs.getString(2));
//				vo.setRegdt(rs.getString(3));
				a.add(vo);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}

		return a;
	}

	public static BoardVO3 selBoard(int intIboard) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT title, ctnt, regdt FROM t_board WHERE iboard = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);	
			ps.setInt(1, intIboard);
			
			rs = ps.executeQuery(); // select 
			
			if(rs.next()) {
				BoardVO3 vo = new BoardVO3();
				
				vo.setIboard(intIboard);
				vo.setTitle(rs.getString("title"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setRegdt(rs.getString("regdt"));
				
				return vo;			
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}	
		return null;
	}
	
	public static int updBoard(BoardVO3 vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "UPDATE t_board SET title = ?, ctnt = ? WHERE  iboard = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIboard());			
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
		return 0;
	}
	
	public static int delBoard(BoardVO3 param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM t_board WHERE iboard = ?";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1,param.getIboard());
//			ps.setInt(1, iboard);
			
			System.out.println(ps.toString());
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}

		return 0;
	}
}
