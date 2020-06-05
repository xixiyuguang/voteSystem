package com.zq.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zq.dao.CandidateDao;
import com.zq.db.JDBCUtils;
import com.zq.po.Admin;
import com.zq.po.Candidate;

public class CandidateDaoImpl implements CandidateDao {
	
	
	
	public Candidate findCandidateById(int id) {
		String sql = "select * from candidate where id=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
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
				return candidate;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, ps, conn);
		}
		return null;
	}

	// 插入候选人
	public Boolean addCandidate(Candidate candidate) {

		String sql = "insert into candidate values(null,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		int flag;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, candidate.getName());
			ps.setString(2, candidate.getSex());
			ps.setInt(3, candidate.getAge());
			ps.setString(4, candidate.getAddress());
			ps.setString(5, candidate.getIntroduce());
			ps.setString(6, candidate.getImage());
			ps.setInt(7, candidate.getBallot());
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

	// list all candidate
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

	/**
	 * 让address和introduce成为账号密码
	 */

	public Candidate findCandidateByAddress(String address) {
		String sql = "select * from candidate where address=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, address);
			rs = ps.executeQuery();
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
				return candidate;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, ps, conn);
		}
		return null;
	}

	// add ballot add piao shu  
	//mysql> UPDATE persondata SET age=age+1;
	public Boolean addCandidateBallot(int id) {
		String sql = "update candidate set ballot = ballot+1 where id = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		conn = JDBCUtils.getConnection();
		try {

			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int b = ps.executeUpdate();
			if(b==1){
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
			JDBCUtils.close(null, ps, conn);
		}
		return null;

	}


	public Boolean deleteCandidate(int id) {
		String sql = "delete  from candidate where id = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int b = ps.executeUpdate();
			if(b ==1){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(null, ps, conn);
		}
		return false;
	}

	//update candidate set name =1 ,sex=1 ,age=1 ,address=1 ,introduce=1 ,image=1  where id =25
	//update candidate set name =?,sex=?,age=?,address=?,introduce=?,image=? where id = ?
	public Boolean updateCandidate(int id, Candidate candidate) {
		String sql = "update candidate set name =?,sex=?,age=?,address=?,introduce=?,image=? where id = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		conn = JDBCUtils.getConnection();
		try {

			ps = conn.prepareStatement(sql);
			ps.setString(1,candidate.getName());
			ps.setString(2,candidate.getSex());
			ps.setInt(3,candidate.getAge());
			ps.setString(4,candidate.getAddress());
			ps.setString(5,candidate.getIntroduce());
			ps.setString(6,candidate.getImage());
			ps.setInt(7, id);
			
			int b = ps.executeUpdate();
			if(b==1){
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
			JDBCUtils.close(null, ps, conn);
		}
		return false;

	}
	
//	SELECT * FROM candidate   ORDER BY  ballot ASC;
//	SELECT * FROM candidate   ORDER BY  ballot DESC;
	public List<Candidate> findAllCandidateByOrder() {
		String sql = "SELECT * FROM candidate   ORDER BY  ballot DESC";
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
