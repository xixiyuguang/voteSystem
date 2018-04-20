package com.zq.dao;

import com.zq.po.Voter;

public interface VoterDao {
	
	public Voter findVoterByIp(String ip);
	
	public Boolean addVoter(Voter voter);
	
	public Boolean updateVoter(String ip, Voter voter);
	
}
