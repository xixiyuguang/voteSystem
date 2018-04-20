package com.zq.dao;

import java.util.List;

import com.zq.po.Candidate;

public interface CandidateDao {
	
	public Boolean addCandidate(Candidate candidate);
	
	//find  all 
	public List<Candidate> findAllCandidate();
	
	//find by   ip	
	public Candidate findCandidateById(int id);
	
	
	//
	public Boolean addCandidateBallot(int id);
	
	public Boolean deleteCandidate(int id) ;
	
	
	public Boolean updateCandidate(int id, Candidate candidate);
	//update candidate set ballot = '' where id = '';
	//update candidate set ballot = '2' where id = '4';
}
