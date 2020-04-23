package com.iu.s5.board.file;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s5.AbstractTestCase;

public class BoardFileDAOTest extends AbstractTestCase{

	@Autowired
	private BoardFileDAO boardFileDAO;
	
	//@Test
	public void fileInsertTest() throws Exception{
		BoardFileVO boardFileVO = new BoardFileVO();
		boardFileVO.setFileNum(2);
		boardFileVO.setNum(2);
		boardFileVO.setFileName("f1");
		boardFileVO.setOriName("of1");
		boardFileVO.setBoard(1);
		
		int result = boardFileDAO.fileInsert(boardFileVO);
		
		assertNotEquals(0, result);
	}

}
