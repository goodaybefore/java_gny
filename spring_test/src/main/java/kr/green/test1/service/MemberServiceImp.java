package kr.green.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.test1.dao.MemberDAO;
import kr.green.test1.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{
	
	@Autowired
	MemberDAO memberDao;
	
	@Override
	public MemberVO login(MemberVO user) {
		if(user ==  null || user.getMe_id()==null) {
			return null;
		}
		
		//정보가 있으면 가져오라고 시키기
		MemberVO DbUser = memberDao.getMember(user.getMe_id());
		System.out.println("불러온 DbUser : "+DbUser);
		return null;
	}

	@Override
	public MemberVO signUp(MemberVO user) {
		
		return null;
	}
	

}
