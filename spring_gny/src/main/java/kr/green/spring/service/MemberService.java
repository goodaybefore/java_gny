package kr.green.spring.service;

import kr.green.spring.vo.MemberVO;

public interface MemberService {
	//login
	MemberVO login(MemberVO member);
	//sign up
	//회원가입 여부 알려주기위해서  boolean으로 지정
	boolean signUp(MemberVO user);
	
}