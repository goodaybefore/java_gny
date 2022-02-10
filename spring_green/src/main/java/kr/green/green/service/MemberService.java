package kr.green.green.service;

import java.util.List;

import kr.green.green.vo.MemberVO;

public interface MemberService {

	MemberVO testSQL(String string);

	boolean signup(MemberVO user);
	MemberVO login(MemberVO user);

	String idCheck(String me_id);

	//회원 정보 수정
	MemberVO updateMember(MemberVO input, MemberVO user);

	//아이디/비밀번호 찾기
	//아이디찾기
	String findId(MemberVO member);
	//비번찾기
	String findPw(MemberVO member);
	
	//회원관리
	List<MemberVO> getAllMember();
	//회원 권한 수정
	String updateAuthority(MemberVO member, MemberVO user);

	void updateAutologin(MemberVO user);
	
	//로그인 유지 기능
	MemberVO selectMemberBySessionId(String value);
	



}
