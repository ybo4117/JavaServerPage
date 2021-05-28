package com.koreait.board7.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.koreait.board7.user.UserEntity;
import com.koreait.board7.DBUtils;

public class UserDAO {

	// 아이디가 있으면 리턴 : 1 아이디가 없으면 리턴 0
	public static int selIdChk(String uid) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT u_id FROM t_user WHERE u_id = ?";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, uid.trim());
			rs = ps.executeQuery();

			if (rs.next()) {
				return 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}

		return 0;
	}

	public static UserEntity selUser(UserEntity param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		UserEntity result = null;

		String sql = "SELECT i_user, u_id, u_pw, u_nm, profileImg FROM t_user WHERE u_id = ?";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			rs = ps.executeQuery();

			if (rs.next()) {

				result = new UserEntity();
				result.setIuser(rs.getInt("i_user"));
				result.setUid(rs.getString("u_id"));
				result.setUpw(rs.getString("u_pw"));
				result.setUnm(rs.getString("u_nm"));
				result.setProfileImg(rs.getString("profileImg"));
			}

			return result;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}

		return result;
	}

	public static int upbUser(UserEntity param) {
		Connection con = null;
		PreparedStatement ps = null;
		String updString = null;

		String sql = "UPDATE t_user SET ";
		if (param.getUpw() != null && !param.getUpw().equals("")) {
			sql += "u_pw = ? ";
			updString = param.getUpw();
		} else if (param.getProfileImg() != null && !param.getProfileImg().equals("")) {
			sql += "profileImg = ? ";
			updString = param.getProfileImg();
		}
		sql += "WHERE i_user = ? ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, updString);
			ps.setInt(2, param.getIuser());

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.close(con, ps);
		}

	}
}
