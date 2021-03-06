package com.iu.s5.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s5.board.BoardService;
import com.iu.s5.board.BoardVO;
import com.iu.s5.board.file.BoardFileDAO;
import com.iu.s5.board.file.BoardFileVO;
import com.iu.s5.util.FileSaver;
import com.iu.s5.util.Pager;

@Service
public class QnaService implements BoardService{

	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private FileSaver fileSaver;
	@Autowired
	private BoardFileDAO boardFileDAO;
	@Autowired
	private ServletContext servletContext;
	
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
		qnaDAO.hitUpdate(num);
		return qnaDAO.boardSelect(num);
	}
	
	@Override
	public int boardWrite(BoardVO boardVO, MultipartFile [] files) throws Exception {
		//1. sequnce num, qna table insert
		int result = qnaDAO.boardWrite(boardVO);
		
		//2. HDD에 파일저장하고 boardFile table insert
		String path = servletContext.getRealPath("resources/uploadQna");
		
		
		
		for(MultipartFile file : files) {
			BoardFileVO boardFileVO = new BoardFileVO();
			String fileName = fileSaver.saveByTransfer(file, path);
			boardFileVO.setNum(boardVO.getNum());
			boardFileVO.setFileName(fileName);
			boardFileVO.setOriName(file.getOriginalFilename());
			boardFileVO.setBoard(2);
			boardFileDAO.fileInsert(boardFileVO);
		}
		
		return qnaDAO.boardWrite(boardVO);
	}
	
	@Override
	public int boardUpdate(BoardVO boardVO, MultipartFile [] files) throws Exception {
		return qnaDAO.boardUpdate(boardVO);
	}
	
	@Override
	public int boardDelete(long num) throws Exception {
		return qnaDAO.boardDelete(num);
	}
	
}
