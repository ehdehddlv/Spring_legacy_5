package com.iu.s5.board.file;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s5.util.FileSaver;

@Service
public class BoardFileService {

	@Autowired
	private BoardFileDAO boardFileDAO;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileSaver fileSaver;
	
	public int fileDelete(String fileName) throws Exception{
		String path = servletContext.getRealPath("/resources/summer");
		
		return fileSaver.deleteFile(fileName, path);
	}
	
	public String fileInsert(MultipartFile files) throws Exception{
		//어느 경로에 무슨이름으로 저장할 꺼니?
		String path = servletContext.getRealPath("/resources/summer");
		System.out.println(path);
		//저장, (파일, 경로)
		path = fileSaver.saveByTransfer(files, path);
		path = servletContext.getContextPath()+"/resources/summer/"+path;
		
		return path;
	}
	
	public int fileDelete(BoardFileVO boardFileVO) throws Exception{
		boardFileVO = boardFileDAO.fileSelect(boardFileVO);
		int result = boardFileDAO.fileDelete(boardFileVO);
		//1. HDD에 삭제
		String board = "uploadnotice";
		if(boardFileVO.getBoard()==2) {
			board = "uploadQna";
		}
		
		String path = servletContext.getRealPath("/resources/"+board);
		fileSaver.deleteFile(boardFileVO.getFileName(), path);
		
		return result;
	}
	
	
	public BoardFileVO fileSelect(BoardFileVO boardFileVO) throws Exception{
		return boardFileDAO.fileSelect(boardFileVO);
	}
	
	
}//end
