package com.koreait.board4.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board4.DBUtils;

public class UserDAO {

	public static int joinUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "INSERT INTO t_user (u_id, u_pw, u_nm, gender) VALUES(?, ?, ?, ?)";

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

	// 로그인 성공 : 1 / 아이디 없음 : 2 / 비밀번호 틀림 : 3 / 에러 : 0
	public static int loginUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM t_user WHERE u_id = ?";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());

			rs = ps.executeQuery();

			if (rs.next()) { // 아이디가 있는경우
				String dbPw = rs.getString("u_pw");

				if (BCrypt.checkpw(param.getUpw(), dbPw)) { // 암호화된 비밀번호가 설정한비밀번와 같을때
					param.setIuser(rs.getInt("i_user"));
					param.setUnm(rs.getString("u_nm"));
					// rs에 있는 i_user의 값과 u_nm의 값을 보내는 것

					return 1;
				} else { // 비밀번호가 다를경우
					return 3;
				}
			} else { // 아이디가 없는 경우
				return 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.close(con, ps, rs);
		}
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
