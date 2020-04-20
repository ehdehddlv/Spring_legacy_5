package com.iu.s5.board.page;

public class Pager {

	private Long curPage; 	//현재 페이지 번호
	private Integer perPage;	//한 페이지 당 보여주려고 하는 글의 갯수
	
	private long startRow; 	//시작 번호
	private long lastRow;	//마지막 번호
	
	private long totalPage;	//전체 페이지
	
	private long totalBlock;	//전체 블록
	private long curBlock;		//현재 블록
	
	private long startNum;	//시작 번호
	private long lastNum;	//마지막 번호
	
	private String kind;
	private String search;
	
	//get,set kind
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	//get,set kind
	
	
	//get,set search
	public String getSearch() {
		if(this.search == null) {
			this.search = "";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	//get,set search

	
	//시작번호, 끝번호
	public void makeRow() {
		System.out.println("curPage : "+this.getCurPage());
		this.startRow = (this.getCurPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getCurPage()*this.getPerPage();
	}
	
	
	//전체
	public void makePage(long totalCount) {
		//1. totalCount : 전체 글의 갯수
		
		//2. totalCount로 totalPage 계산
		this.totalPage = totalCount/this.getPerPage();
		if(totalCount % this.getPerPage() != 0) {
			this.totalPage++;
		}
		
		//3. totalPage로 totalBlock 계산
		long perBlock = 5L; //block 페이지 수
		this.totalBlock = totalPage/perBlock;
		if(totalPage % perBlock != 0) {
			this.totalBlock++;
		}
		
		//4. curPage로 curBlock 찾기
		this.curBlock = this.curPage/perBlock;
		if(this.curPage % perBlock != 0) {
			this.curBlock++;
		}
		
		//5. curBlock으로 startNum, lastNum 계산
		this.startNum = (this.curBlock-1)*perBlock+1;
		this.lastNum = curBlock*perBlock;
		
		//마지막 페이지에서 끊기
		if(this.curBlock == this.totalBlock) {
			this.lastNum = this.totalPage;
		}
	}
	
	//get totalblock
	public long getTotalBlock() {
		return totalBlock;
	}
	//get totalblock

	//get curblock
	public long getCurBlock() {
		return curBlock;
	}
	//get curblock
	
	//get startnum, lastnum
	public long getStartNum() {
		return startNum;
	}

	public long getLastNum() {
		return lastNum;
	}
	//get startnum, lastnum

	//get totalpage
	public long getTotalPage() {
		return totalPage;
	}
	//get totalpage
	
	//get startrow, lastrow
	public long getStartRow() {
		return startRow;
	}


	public long getLastRow() {
		return lastRow;
	}
	//get startrow, lastrow
	
	
	//long, integer/ curpage, perpage
	public Long getCurPage() {
		if(this.curPage == null || this.curPage == 0) {
			this.curPage = 1L;
		}
		return curPage;
	}
	public void setCurPage(Long curPage) {
		this.curPage = curPage;
	}
	public Integer getPerPage() {
		if(this.perPage == null || this.perPage == 0) {
			this.perPage = 10;
		}
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	//long, integer
	
	
}
