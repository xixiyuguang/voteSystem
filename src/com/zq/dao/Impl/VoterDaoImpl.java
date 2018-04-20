package com.zq.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.zq.dao.VoterDao;
import com.zq.db.JDBCUtils;
import com.zq.po.Candidate;
import com.zq.po.Voter;

public class VoterDaoImpl implements VoterDao {

	public Voter findVoterByIp(String ip) {
		String sql = "select * from voter where ip=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, ip);
			rs = ps.executeQuery();
			while (rs.next()) {
				Voter voter = new Voter();
				voter.setId(rs.getInt("id"));
				voter.setIp(rs.getString("ip"));
				voter.setCreate_date(rs.getTimestamp("create_date"));
				voter.setUpdate_date(rs.getTimestamp("update_date"));
				return voter;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, ps, conn);
		}
		return null;
	}

	public Boolean addVoter(Voter voter) {
		// <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		// <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
		//
		// id ip create_date update_date 2017-06-14
		// insert into voter values(null,'11','2017-06-14 16:45:23','2017-06-14
		// 16:45:23')
		String sql = "insert into voter values(null,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		int flag;

		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {

			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, voter.getIp());
			ps.setTimestamp(2, voter.getCreate_date());
			ps.setTimestamp(3, voter.getUpdate_date());
			flag = ps.executeUpdate();
			System.out.println("f=====when f ==1 it is ok" + flag);
			if (flag == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(null, ps, conn);
		}
		return false;
	}

	// update the update_date
	//Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// String myString = "2017-06-17 23:22:11";
	// Timestamp s = Timestamp.valueOf(myString);
 
	public Boolean updateVoter(String ip, Voter voter) {
		String sql = "update voter set update_date =? where ip = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		conn = JDBCUtils.getConnection();
		try {

			ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, voter.getUpdate_date());
			ps.setString(2, ip);
			int b = ps.executeUpdate();
			if (b == 1) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			JDBCUtils.close(null, ps, conn);
		}
		return false;

	}

}
