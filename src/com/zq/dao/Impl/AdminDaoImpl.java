package com.zq.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zq.dao.AdminDao;
import com.zq.db.JDBCUtils;
import com.zq.po.Admin;

public class AdminDaoImpl implements AdminDao {

	public Admin findAdminByAccount(String account) {
		String sql = "select * from admin where account=?";

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			rs = ps.executeQuery();
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setName(rs.getString("name"));
				admin.setAccount(rs.getString("account"));
				admin.setPassword(rs.getString("password"));
				return admin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, ps, conn);
		}
		return null;

	}

	public Boolean addAdmin(Admin admin) {
		String sql = "insert into admin values(null,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		int f;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, admin.getName());
			ps.setString(2, admin.getAccount());
			ps.setString(3, admin.getPassword());
			f = ps.executeUpdate();
			System.out.println("f=====when f ==1 it is ok" + f);
			if (f == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
