package kr.green.spring.dao;

import org.apache.ibatis.annotations.Param;
import kr.green.spring.vo.MemberVO;

public interface MemberDAO {
	//@Param("me_id")를 붙여줘야함
	//검색할거니까 리턴타입이 MemberVO
	MemberVO getMember(@Param("me_id")String me_id);
	//회원가입
	//검색같은거 딱히 안하니가 리턴타입이 void
	void insertMember(@Param("user")MemberVO user);
	//회원정보수정(/mypage)
	void updateMember(@Param("user")MemberVO user);
	MemberVO findMember(@Param("user")MemberVO member);
}
