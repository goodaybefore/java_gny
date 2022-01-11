package kr.green.green.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.green.vo.MemberVO;

public interface MemberDAO {
	//test
	MemberVO testSQL(@Param("id")String id);
	//get member from sql.community.member;
	MemberVO getMember(@Param("me_id")String me_id);
	void insertMember(@Param("user")MemberVO user);
	MemberVO selectMember(@Param("me_id")String me_id);
}
