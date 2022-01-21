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
		
		//회원 insert해라
		memberDao.insertMember(user);
		return true;
	}
//
//	@Override
//	public MemberVO getMember(MemberVO user) {
//		if(user.getMe_id()==null || user.getMe_pw()==null) return null;
//		
//		//DB에서 id로 검색하기
//		MemberVO dbuser = memberDao.getMember(user.getMe_id());
//		//DB에 없으면 null return 
//		if(dbuser==null) return null;
//		
//		return user;
//	}

	@Override
	public MemberVO login(MemberVO user) {
		//user.getMe_id().trim().length()==0 은 스페이스만 입력하거나 공백처리하거나 했다는 뜻
		if(user==null||user.getMe_id()==null
				|| user.getMe_id().trim().length()==0) return null;
		MemberVO dbuser = memberDao.selectMember(user.getMe_id());
		if(dbuser == null) return null;
		if(!passwordEncoder.matches(user.getMe_pw(), dbuser.getMe_pw())) return null;
		return dbuser;
	}
	
}
