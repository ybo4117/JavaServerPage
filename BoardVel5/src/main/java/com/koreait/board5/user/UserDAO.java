package com.koreait.board5.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.koreait.board5.DBUtils;

public class UserDAO {
	
	public static int insUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO t_user (u_id, u_pw, u_nm, gender) VALUES (?, ?, ?, ?)";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			ps.setString(2, param.getUpw());
			ps.setString(3, param.getUnm());
			ps.setInt(4, param.getGender());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
		return 0;
		
	}
	
	public static UserVO selUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		
		UserVO result = null;
		
		String sql = "SELECT i_user, u_id, u_pw, u_nm FROM t_user WHERE u_id = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				result = new UserVO();				
				result.setIuser(rs.getInt("i_user"));
				result.setUid(rs.getString("u_id"));
				result.setUpw(rs.getString("u_pw"));
				result.setUnm(rs.getString("u_nm"));				
			}
			
			return result;	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return result;		
	}
	
	public static boolean checkId(UserVO param) {
		boolean result = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM t_user WHERE u_id = ?";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			rs = ps.executeQuery();

			if (rs.next()) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}

		return result;
	}

}
