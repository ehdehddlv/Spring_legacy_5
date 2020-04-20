package com.iu.s5.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s5.member.page.Pager;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "memberList", method = RequestMethod.GET)
	public ModelAndView memberList(ModelAndView mv, Pager pager) throws Exception{
		List<MemberVO> ar = memberService.memberList(pager);
		MemberVO memberVO = new MemberVO();
		
		mv.addObject("mlist", ar);
		mv.addObject("vo", memberVO);
		mv.setViewName("member/memberList");
		
		return mv;
		
	}
	
	
	
	
	
	
	
}

