package kr.green.green.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.green.dao.MemberDAO;
import kr.green.green.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{
	@Autowired
	MemberDAO memberDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public MemberVO testSQL(String id) {
		return memberDao.testSQL(id);
	}

	@Override
	public boolean signup(MemberVO user) {
		
		if(user==null) return false;
		//아이디가 공백이거나 없는경우
		if(user.getMe_id()==null || user.getMe_id().trim().length() == 0) return false;
		//비밀번호 확인
		if(user.getMe_pw()==null) return false;
		//성별 가능한건지 확인
		
		if(memberDao.getMember(user.getMe_id()) !=  null) return false;
		
		//가능하면 회원가입 진행
		//비밀번호 암호화
		String encPw = passwordEncoder.encode(user.getMe_pw());
		user.setMe_pw(encPw);
		System.out.println("user "+user);
		
		//회원 insert해라
		memberDao.insertMember(user);
		return true;
	}
	
}
