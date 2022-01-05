package kr.green.test1.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.test1.vo.MemberVO;

public interface MemberDAO {
	MemberVO getMember(@Param("me_id")String me_id);
}
