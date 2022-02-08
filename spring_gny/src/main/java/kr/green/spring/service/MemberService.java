package kr.green.spring.service;

import java.util.List;

import kr.green.spring.vo.MainCategoryVO;
import kr.green.spring.vo.MemberVO;
import kr.green.spring.vo.MiddleCategoryVO;
import kr.green.spring.vo.SubCategoryVO;

public interface MemberService {
	//login
	MemberVO login(MemberVO member);
	//sign up
	//회원가입 여부 알려주기위해서  boolean으로 지정
	boolean signUp(MemberVO user);
	boolean idDuplicated(String id);
	
	//회원정보수정(/mypage)
	MemberVO updateMember(MemberVO input, MemberVO user);
	
	//회원정보 찾기
	String findId(MemberVO member);
	String findPW(MemberVO member);
	
	//자동로그인
	void updateAutoLogin(MemberVO user);
	MemberVO selectMemberBySessionId(String value);
	
	//대중소분류
	List<MainCategoryVO> selectMainCategory();
	List<MiddleCategoryVO> selectMiddleCategory(Integer mi_ma_num);
	List<SubCategoryVO> selectSubCategory(Integer su_mi_num);
	
	
	
}
