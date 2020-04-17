package com.iu.s5.notice;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s5.AbstractTestCase;
import com.iu.s5.board.BoardVO;

public class NoticeDAOTest extends AbstractTestCase {

	@Autowired
	private NoticeDAO noticeDAO;

	//@Test
	public void daoIsnull() {
		assertNotNull(noticeDAO);
	}

	
	//@Test 
	public void boardWriteTest() throws Exception{
		String writer = "";
		String title = "";
		String contents = "";
		for(int i=0; i<150; i++) {
			NoticeVO noticeVO = new NoticeVO(); 
			if(i%3==0) {
				writer = "iu";
				title = "Alert";
				contents = "Samsung";
			}else if(i%3==1) {
				writer = "choa";
				title = "computer";
				contents = "apple";
			}else {
				writer = "suzy";
				title = "os";
				contents = "linux";
			}
			noticeVO.setTitle(title+i);
			noticeVO.setWriter(writer); 
			noticeVO.setContents(contents+i); 
			int result = noticeDAO.boardWrite(noticeVO);
			if(i==50 || i==100) {
				Thread.sleep(1000);
			}
		}
		
 
	}
	 

	//@Test
	public void boardDeleteTest() throws Exception {
		int result = noticeDAO.boardDelete(1);

		assertNotEquals(0, result);
	}

	//@Test
	public void boardUpdateTest() throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("test title1");
		noticeVO.setContents("test contents1");
		noticeVO.setNum(2);
		int result = noticeDAO.boardUpdate(noticeVO);

		assertEquals(1, result);
	}

	//@Test
	public void hitUpdateTest(long num) throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setNum(2);
		int result = noticeDAO.hitUpdate(num);

		assertEquals(1, result);
	}

	//@Test
	public void boardSelectTest() throws Exception {
		BoardVO boardVO = noticeDAO.boardSelect(2);

		assertNotNull(boardVO);
	}
	
	//@Test
//	public void daoTest() throws Exception{
//		List<BoardVO> ar = this.boardListTest();
//		assertNotEquals(0, ar.size());
//	}
	
//	public List<BoardVO> boardListTest() throws Exception{
//		return noticeDAO.boardList();
//	}

}
