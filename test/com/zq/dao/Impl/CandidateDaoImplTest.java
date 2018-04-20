package com.zq.dao.Impl;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.zq.po.Candidate;

public class CandidateDaoImplTest {

	@Test
	public void testAddCandidate() {
		Candidate candidate = new Candidate();
		candidate.setName("于光6");
		candidate.setSex("男");
		candidate.setAge(1);
		candidate.setAddress("地址");
		candidate.setIntroduce("介绍");
		candidate.setImage("图片地址");
		candidate.setBallot(12);	
		
		CandidateDaoImpl candidateDaoImpl = new CandidateDaoImpl();
		Boolean b = candidateDaoImpl.addCandidate(candidate);
		System.out.println(b);
	}

	@Test
	public void testFindAllCandidate() {
		CandidateDaoImpl candidateDaoImpl = new CandidateDaoImpl();
		 Boolean b = candidateDaoImpl.addCandidateBallot(3);
		 System.out.println(b);
		// List<Candidate> list = candidateDaoImpl.findAllCandidate();
		// for (Candidate c:list){
		// System.out.println(c.getName());
		// }
//		Boolean b = candidateDaoImpl.deleteCandidate(3);
//		System.out.println(b);
	}

	@Test
	public void testFindCandidateById() {
		CandidateDaoImpl candidateDaoImpl = new CandidateDaoImpl();
		Candidate c = candidateDaoImpl.findCandidateById(4);
		System.out.println(c.getName());
	}

	@Test
	public void testUpdate() {
		CandidateDaoImpl candidateDaoImpl = new CandidateDaoImpl();
		Candidate candidate = new Candidate();
		candidate.setName("于光");
		candidateDaoImpl.updateCandidate(25, candidate);
	}
}
