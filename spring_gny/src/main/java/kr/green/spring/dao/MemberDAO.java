package kr.green.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.MainCategoryVO;
import kr.green.spring.vo.MemberVO;
import kr.green.spring.vo.MiddleCategoryVO;
import kr.green.spring.vo.SubCategoryVO;

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
	
	//AdminController
	//전체 회원 불러오기
	List<MemberVO> selectMemberList();
	
	//자동로그인 session저장
	void updateAutoLogin(@Param("user")MemberVO user);
	MemberVO selectMemberBySessionId(@Param("me_session_id")String me_session_id);
	
	
	//Param Test
	MemberVO ParamTest1(@Param("user")MemberVO user);
	MemberVO ParamTest2(MemberVO user);
	
	//대중소분류
	List<MainCategoryVO> selectMainCategory();
	List<MiddleCategoryVO> selectMiddleCategory(@Param("mi_ma_num")Integer mi_ma_num);
	List<SubCategoryVO> selectSubCategory(@Param("su_mi_num")Integer su_mi_num);
}
