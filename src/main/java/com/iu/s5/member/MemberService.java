package com.iu.s5.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s5.member.board.BoardService;
import com.iu.s5.member.page.Pager;

@Service
public class MemberService implements BoardService{

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public List<MemberVO> memberList(Pager pager) throws Exception {
		
		pager.makeRow();
		
		long totalCount = memberDAO.memberCount(pager);
		pager.makePage(totalCount);
		
		return memberDAO.memberList(pager);
	}
}
