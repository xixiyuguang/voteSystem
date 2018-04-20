package com.zq.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class test {

	@Test
	public void test() throws Exception {

		Connection conn = JDBCUtils.getConnection();
		
		 Statement stat = conn.createStatement();
	
		  ResultSet rs = stat.executeQuery("select * from admin");
		  while(rs.next()){
			 System.out.println("id  = "+rs.getString("id"));
		  }
		  conn.close();
		System.out.println("deal");

	}

}
