package kr.green.spring.dao;

import org.apache.ibatis.annotations.Param;
import kr.green.spring.vo.MemberVO;

public interface MemberDAO {
	//@Param("me_id")를 붙여줘야함
	MemberVO getMember(@Param("me_id")String me_id);
}
