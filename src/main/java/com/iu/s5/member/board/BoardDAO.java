package com.iu.s5.member.board;

import java.util.List;

import com.iu.s5.member.MemberVO;
import com.iu.s5.member.page.Pager;

public interface BoardDAO {

	//count
	public long memberCount(Pager pager) throws Exception;
	
	//List
	public List<MemberVO> memberList(Pager pager) throws Exception;
}
