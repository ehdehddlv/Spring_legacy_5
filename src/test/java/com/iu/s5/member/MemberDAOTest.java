package com.iu.s5.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s5.AbstractTestCase;
import com.iu.s5.member.memberFile.MemberFileDAO;
import com.iu.s5.member.memberFile.MemberFileVO;
import com.iu.s5.notice.NoticeVO;

public class MemberDAOTest extends AbstractTestCase{

	@Autowired
	private MemberDAO memberDAO;
	
	
	//@Test
	public void memberJoinTest() throws Exception {
		String id = "";
		String password = "";
		String name = "";
		int age = 0;
		String phone = "";
		String email = "";
		for(int i=0; i<100; i++) {
			MemberVO memberVO = new MemberVO(); 
			if(i%3==0) {
				id = "iu1";
				password = "iupw1";
				name = "iua";
				age = age++;
				phone = "01045671234";
				email = "iu@com";
			}else if(i%3==1) {
				id = "choa1";
				password = "choa1";
				name = "choaa";
				age = age++;
				phone = "01067891234";
				email = "choa@com";
			}else {
				id = "suzy1";
				password = "suzy1";
				name = "suzya";
				age = age++;
				phone = "01012346789";
				email = "suzy@com";
			}
			memberVO.setId(id+i);
			memberVO.setPassword(password+i);
			memberVO.setName(name+i);
			memberVO.setAge(age+i);
			memberVO.setPhone(phone+i);
			memberVO.setEmail(email+i);
			int result = memberDAO.memberJoin(memberVO);
			if(i==30 || i==60) {
				Thread.sleep(1000);
			}
	}

}
}
