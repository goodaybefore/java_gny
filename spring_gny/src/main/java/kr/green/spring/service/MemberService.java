package kr.green.spring.service;

import kr.green.spring.vo.MemberVO;

public interface MemberService {
	//login
	MemberVO login(MemberVO member);
	//sign up
	MemberVO signUp(MemberVO user);
	
}
