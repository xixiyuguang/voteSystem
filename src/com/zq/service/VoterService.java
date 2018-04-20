package com.zq.service;

import com.zq.dao.Impl.VoterDaoImpl;
import com.zq.po.Voter;

public class VoterService {
	VoterDaoImpl voterDaoImpl = new VoterDaoImpl();

	public Voter findVoterByIp(String ip) {
		
		Voter voter = voterDaoImpl.findVoterByIp(ip);
		return voter;
	}

	public Boolean addVoter(Voter voter) {

		return voterDaoImpl.addVoter(voter);
	}

	public Boolean updateVoter(String ip, Voter voter) {
		
		return voterDaoImpl.updateVoter(ip, voter);
	}

}
