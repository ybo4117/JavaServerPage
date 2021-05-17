package com.koreait.board5.cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board5.DBUtils;

public class CmtDAO {
	
	
	public static void insCmt(CmtVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO t_board_cmt (iboard, i_user, cmt) VALUES (?, ?, ?)";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());
			ps.setString(3, param.getCmt());
			
			ps.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
	}

	public static List<CmtVO> selCmtList(int iboard) {
		List<CmtVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT A.icmt, A.i_user, A.cmt, A.regdate, B.u_nm from t_board_cmt A INNER JOIN t_user B ON A.i_user = B.i_user WHERE iboard = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				CmtVO vo = new CmtVO();
				vo.setIcmt(rs.getInt("icmt"));
				vo.setIuser(rs.getInt("i_user"));
				vo.setCmt(rs.getString("cmt"));
				vo.setRegdate(rs.getString("regdate"));
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

	public static int delCmt(CmtVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM t_board_cmt WHERE icmt = ? AND i_user = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIcmt());
			ps.setInt(2, param.getIuser());
			
			return ps.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
		
		return 0;		
	}
}
