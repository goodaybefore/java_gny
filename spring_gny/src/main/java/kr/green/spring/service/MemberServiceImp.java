package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import kr.green.spring.dao.MemberDAO;
import kr.green.spring.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{
	@Autowired
	MemberDAO memberDao;
	
	//암호화를 위한 객체
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public MemberVO login(MemberVO member) {
		if(member == null || member.getMe_id() == null) return null;
		MemberVO Dbuser = memberDao.getMember(member.getMe_id());
		//로그인 성공시 회원정보를, 실패하면 null을 반환
		if(Dbuser ==null) return null;
		//matches(원래 비번, 암호화된비번) : 같으면(비번이맞으면) true, 다르면 false
		if(passwordEncoder.matches(member.getMe_pw(), Dbuser.getMe_pw())) return Dbuser;
		return null;
	}

	@Override
	public boolean signUp(MemberVO user) {
		//회원정보가 없으면 false
		if(user==null) return false;
		if(user.getMe_id()==null) return false;
		if(user.getMe_pw()==null) return false;
		if(memberDao.getMember(user.getMe_id()) != null) return false;//이미 존재하는 아이디이면 컷
		
		
		//암호화된 비밀번호를 저장
		String encPw = passwordEncoder.encode(user.getMe_pw());
		//비번에 암호화된 비번을 덮어쓰기
		user.setMe_pw(encPw);
		
		
		//이외 필수항목들이 null이면 false 해줘야함 => 화면에서도 해주지만 java에서도 해줘야함.. 사용자들이 항상 옳게 접근한다는 보장이 없기 때문에ㅜ
		//javascript에서 거를거 다 걸러주고 id, pw, name, birth, gender, address 다 줬기 때문에 그냥 바로 insert 해도 됨
		memberDao.insertMember(user);
		return true;
	}

	@Override
	public boolean idDuplicated(String id) {
		MemberVO user = memberDao.getMember(id);
		if(user == null) return false;
		return true;
	}
	
}
