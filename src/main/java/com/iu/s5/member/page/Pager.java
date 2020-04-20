package com.iu.s5.member.page;

public class Pager {

	private Long curPage;
	private Integer perPage;
	
	private long startRow;
	private long lastRow;
	
	private long totalPage;
	
	private long totalBlock;
	private long curBlock;
	
	private long startNum;
	private long lastNum;
	
	private String mkind;
	private String msearch;

	

	public void makeRow() {
		this.startRow = (this.getCurPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getCurPage()*this.getPerPage();
	}
	
	public void makePage(long totalCount) {
		
		this.totalPage = totalCount/this.getPerPage();
		if(totalCount % this.getPerPage() != 0) {
			this.totalPage++;
		}
		
		long perBlock = 5L;
		this.totalBlock = totalPage/perBlock;
		if(totalPage % perBlock != 0) {
			this.totalBlock++;
		}
		
		this.curBlock = this.curPage/perBlock;
		if(this.curPage % perBlock != 0) {
			this.curBlock++;
		}
		
		this.startNum = (this.curBlock-1)*perBlock+1;
		this.lastNum = curBlock*perBlock;
		
		if(this.curBlock == this.totalBlock) {
			this.lastNum = this.totalPage;
		}
	}
	
	//kind
		public String getmKind() {
			return mkind;
		}

		public void setmKind(String mkind) {
			this.mkind = mkind;
		}

		//search
		public String getmSearch() {
			if(this.msearch == null) {
				this.msearch = "";
			}
			return msearch;
		}

		public void setmSearch(String msearch) {
			this.msearch = msearch;
		}
	
	
	//startnum
	public long getStartNum() {
		return startNum;
	}

	//lastnum
	public long getLastNum() {
		return lastNum;
	}
	
	//totalblock
	public long getTotalBlock() {
		return totalBlock;
	}

	//curblock
	public long getCurBlock() {
		return curBlock;
	}


	//totalpage
	public long getTotalPage() {
		return totalPage;
	}
	
	
	//start, last
	public long getStartRow() {
		return startRow;
	}
	public long getLastRow() {
		return lastRow;
	}
	
	
	//curpage / perpage
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
	
	
}
