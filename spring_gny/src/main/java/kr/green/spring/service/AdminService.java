package kr.green.spring.service;

import java.util.List;

import kr.green.spring.vo.MemberVO;

public interface AdminService {
	//회원리스트출력
	List<MemberVO> getMemberList();
	//회원권한설정
	boolean updateAuthority(MemberVO member);

}
