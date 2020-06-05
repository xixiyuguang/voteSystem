package com.zq.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zq.db.JDBCUtils;
import com.zq.po.Admin;
import com.zq.po.Candidate;
import com.zq.po.Message;

public class MessageDaoImp {

	
	public Boolean addMessage(Message message) {
		String sql = "insert into message values(null,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			int flag1;
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, message.getName());
			ps.setString(2, message.getPhone());
			ps.setString(3, message.getWords());
		 flag1 = ps.executeUpdate();
			 if(flag1 ==1){
				 return true;
			 }
			 else{
				 return false;
			 }
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	 
  }
	public List<Candidate> findAllCandidate() {
		String sql = "select * from candidate";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<Candidate> list = new ArrayList<Candidate>();
		try {
			conn = JDBCUtils.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Candidate candidate = new Candidate();
				candidate.setId(rs.getInt("id"));
				candidate.setName(rs.getString("name"));
				candidate.setSex(rs.getString("sex"));
				candidate.setAge(rs.getInt("age"));
				candidate.setAddress(rs.getString("address"));
				candidate.setImage(rs.getString("image"));
				candidate.setIntroduce(rs.getString("introduce"));
				candidate.setBallot(rs.getInt("ballot"));
				list.add(candidate);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, st, conn);
		}
		return list;
	}
	
	
}
