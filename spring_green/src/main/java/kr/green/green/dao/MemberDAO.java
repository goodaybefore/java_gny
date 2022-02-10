package kr.green.green.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.green.vo.MemberVO;

public interface MemberDAO {
	//test
	MemberVO testSQL(@Param("id")String id);
	//get member from sql.community.member;
	MemberVO getMember(@Param("me_id")String me_id);
	void insertMember(@Param("user")MemberVO user);
	MemberVO selectMember(@Param("me_id")String me_id);
	//회원 정보 수정
	void updateMember(@Param("user")MemberVO input);
	//회원 ID 찾기
	MemberVO selectMemberByEmail(@Param("user")MemberVO member);

	//회원관리
	List<MemberVO> selectAllMember();
	//회원 권한 변경
	void updateAuthority(@Param("user")MemberVO member);
}
