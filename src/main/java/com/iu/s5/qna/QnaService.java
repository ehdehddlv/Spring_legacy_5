package com.iu.s5.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s5.board.BoardService;
import com.iu.s5.board.BoardVO;
import com.iu.s5.util.Pager;

@Service
public class QnaService implements BoardService{

	@Autowired
	private QnaDAO qnaDAO;
	
	public int boardReply(BoardVO boardVO) throws Exception{
		int result = qnaDAO.boardReplyUpdate(boardVO);
		result = qnaDAO.boardReply(boardVO);
		return result;
	}
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {		
		pager.makeRow();
		pager.makePage(qnaDAO.boardCount(pager));
		
		return qnaDAO.boardList(pager);
	}
	
	@Override
	public BoardVO boardSelect(long num) throws Exception {
		//qnaDAO.hitUpdate(num);
		return qnaDAO.boardSelect(num);
	}
	
	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		return qnaDAO.boardWrite(boardVO);
	}
	
	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		return qnaDAO.boardUpdate(boardVO);
	}
	
	@Override
	public int boardDelete(long num) throws Exception {
		return qnaDAO.boardDelete(num);
	}
	
}
