package com.zq.service;

import java.util.List;

import com.zq.dao.Impl.CandidateDaoImpl;
import com.zq.po.Candidate;

public class CandidateService {

	private CandidateDaoImpl dao = new CandidateDaoImpl();

	public Boolean addCandidate(Candidate candidate) {
		Boolean b = dao.addCandidate(candidate);
		System.out.println("b===" + b);
		return b;
	}

	public List<Candidate> listAll() {
		List<Candidate> list = dao.findAllCandidate();
		return list;
	}
	public List<Candidate> getBallotAll() {
		List<Candidate> list = dao.findAllCandidateByOrder();
		return list;
	}

	public Candidate findCandidateById(int id) {
		Candidate candidate = dao.findCandidateById(id);
		return candidate;
	}

	public Boolean addCandidateBallot(int id) {
		Boolean b = dao.addCandidateBallot(id);
		return b;
	}
	
	public Boolean updateCandidate(int id, Candidate candidate) {
		Boolean b = dao.updateCandidate(id, candidate);
		return b;
	}
	
	public Boolean deleteCandidate(int id){

		return dao.deleteCandidate(id);
		
	}
}
