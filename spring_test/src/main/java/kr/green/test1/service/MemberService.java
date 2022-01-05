package kr.green.test1.service;

import kr.green.test1.vo.MemberVO;

public interface MemberService {
	//로그인
	public MemberVO login(MemberVO user);
	//회원가입
	public MemberVO signUp(MemberVO user);
}
