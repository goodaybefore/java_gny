package kr.green.green.service;

import kr.green.green.vo.MemberVO;

public interface MemberService {

	MemberVO testSQL(String string);

	boolean signup(MemberVO user);
	MemberVO login(MemberVO user);

	String idCheck(String me_id);

	//회원 정보 수정
	MemberVO updateMember(MemberVO input, MemberVO user);
	



}
