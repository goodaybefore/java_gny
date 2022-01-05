package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.green.spring.dao.MemberDAO;
import kr.green.spring.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{
	@Autowired
	MemberDAO memberDao;

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null || member.getMe_id() == null) return null;
		MemberVO Dbuser = memberDao.getMember(member.getMe_id());
		System.out.println("Dbuser"+Dbuser);
		return null;
	}

	@Override
	public MemberVO signUp(MemberVO user) {
		//생일은 임의로 null 처리
		user.setMe_birth(null);
		//javascript에서 거를거 다 걸러주고 id, pw, name, birth, gender, address 다 줬기 때문에 그냥 바로 insert 해도 됨
		memberDao.setMember(user);
		return null;
	}
	
}
