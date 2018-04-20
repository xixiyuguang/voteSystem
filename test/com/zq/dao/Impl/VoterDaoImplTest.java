package com.zq.dao.Impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.zq.po.Voter;




public class VoterDaoImplTest {

	@Test
	public void testFindVoterByIp() {
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		Voter voter  = new Voter();
		voter.setIp("5");
		//voter.setUpdate_date(timeStamp);
	
		
		VoterDaoImpl  voterDaoImpl  =new VoterDaoImpl();
		Boolean b = voterDaoImpl.addVoter(voter);
		System.out.println(b);
	}


	@Test
	public void testfindByIp() {
		VoterDaoImpl  voterDaoImpl  =new VoterDaoImpl();
		Voter voter  = voterDaoImpl.findVoterByIp("1");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
		String time =format.format(voter.getUpdate_date()) ;
		System.out.println(time);
	}
	@Test
	public void testAddVoter() throws ParseException {
		VoterDaoImpl  voterDaoImpl  =new VoterDaoImpl();
		Voter voter = new Voter();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		 String myString = "2017-06-17 23:22:11";
		 Timestamp s = Timestamp.valueOf(myString);
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		voter.setUpdate_date(s);
		voterDaoImpl.updateVoter("1", voter);
	}

}
