package com.koreait.board5.fav;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.koreait.board5.DBUtils;

public class FavDAO {
	public static void insFav(int iboard, int iuser) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO t_board_fav (i_user, iboard) VALUES (? ,?)";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iuser);
			ps.setInt(2, iboard);
			
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
	
	public static void delFav(int iboard, int iuser) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM t_board_fav WHERE i_user = ? AND iboard = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iuser);
			ps.setInt(2, iboard);
			
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
}
