package com.iu.s5.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s5.member.board.BoardDAO;
import com.iu.s5.member.page.Pager;

@Repository
public class MemberDAO implements BoardDAO{

	@Autowired
	private SqlSession sqlsession;
	private final String NAMESPACE = "com.iu.s5.member.MemberDAO.";
	
	@Override
	public long memberCount(Pager pager) throws Exception {
		return sqlsession.selectOne(NAMESPACE+"memberCount", pager);
	}
	
	@Override
	public List<MemberVO> memberList(Pager pager) throws Exception {
		return sqlsession.selectList(NAMESPACE+"memberList", pager);
	}
}
