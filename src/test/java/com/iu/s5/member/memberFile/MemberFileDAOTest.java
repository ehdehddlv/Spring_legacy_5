package com.iu.s5.member.memberFile;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s5.AbstractTestCase;

public class MemberFileDAOTest extends AbstractTestCase{

	@Autowired
	private MemberFileDAO memberFileDAO;
	
	//@Test
	public void fileInsertTest() throws Exception{
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setId("iu1");
		memberFileVO.setFileName("iu1_file");
		memberFileVO.setOriName("iu1_ori");
		
		int result = memberFileDAO.fileInsert(memberFileVO);
		
		assertNotEquals(0, result);
	}
	
	
	public void fileUpdateTest() throws Exception{
		MemberFileVO memberFileVO = new MemberFileVO();
		
	}
	
	
	
}
