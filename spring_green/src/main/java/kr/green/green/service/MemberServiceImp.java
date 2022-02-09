package kr.green.green.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	@Autowired
	private JavaMailSender mailSender;

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

	@Override
	public String idCheck(String me_id) {
		MemberVO user = memberDao.selectMember(me_id);
		if(user==null) return "true";
		else return "false";
	}

	@Override
	public MemberVO updateMember(MemberVO input, MemberVO user) {
		if(user == null || input == null || input.getMe_id() == null || input.getMe_id().length()==0) return null;
		if(input.getMe_name()==null || input.getMe_birth()==null||input.getMe_gender()==null) return null;
		
		//아이디 덮어쓰기
		input.setMe_id(user.getMe_id());
		//권한 덮어쓰기
		input.setMe_authority(user.getMe_authority());
		System.out.println("input : "+input);
		//비번입력 안한경우
		if(input.getMe_pw() == null || input.getMe_pw().length() == 0) {
			input.setMe_pw(user.getMe_pw());
		}else {
		//비번입력을 한 경우
			String encPw = passwordEncoder.encode(input.getMe_pw());
			input.setMe_pw(encPw);
		}
		//주소입력 안한경우
		if(input.getMe_address() == null || input.getMe_address().length()==0) {
			input.setMe_address(user.getMe_address());
		}
		//폰번호 입력 안한경우
		if(input.getMe_phone()== null)
			input.setMe_phone(user.getMe_phone());
		
		//변경사항 반영
		memberDao.updateMember(input);
		
		return input;
	}

	@Override
	public String findId(MemberVO member) {
		if(member == null || member.getMe_email() == null || member.getMe_name() == null) return null;
		//이메일, 이름으로 아이디 찾기
		//mapper에서 limit 1 해주기 => 1개만 선택되도록
		MemberVO findUser = memberDao.selectMemberByEmail(member);
		if(findUser == null) return null;
		return findUser.getMe_id();
	}

	@Override
	public String findPw(MemberVO member) {
		if(member == null || member.getMe_email() == null || member.getMe_id()==null) return "false";
		MemberVO dbuser = memberDao.selectMember(member.getMe_id());
		if(dbuser == null || !dbuser.getMe_email().equals(member.getMe_email())) return "false";
		
		//랜덤한 n자리 숫자 만들기
		String newPw = createRandom(6);
		//비번 암호화해서 DB에 저장
		String encPw = passwordEncoder.encode(newPw);
		dbuser.setMe_pw(encPw);
		memberDao.updateMember(dbuser);
		
		//변경된 비밀번호를 이메일로 보내주기
		String setfrom = "goodaybefore@gmail.com";         
	    String tomail  = member.getMe_email();     // 받는 사람 이메일
	    String title   = "변경된 비밀번호 안내";      // 제목
	    String content = "변경된 비밀번호는 "+newPw+" 입니다.";    // 내용

	    try {
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper messageHelper 
	            = new MimeMessageHelper(message, true, "UTF-8");

	        messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
	        messageHelper.setTo(tomail);     // 받는사람 이메일
	        messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
	        messageHelper.setText(content);  // 메일 내용
	        mailSender.send(message);
	    } catch(Exception e){
	        System.out.println(e);
	        return "errer";
	    }
		
		return "true";
	}

	private String createRandom(int size) {
		String newPw = "";
		//size 길이만큼 만들어야하니까 반복
		for(int i=0;i<size;i++) {
			int max = 61, min = 0;
			int rand = (int)(Math.random()*(max - min + 1)+min);
			if(rand>=0 && rand <=9) {
				newPw += (char)('0' + rand);//'0'으로부터 rand번째에 있는 char
			}else if(rand<=35) {
				newPw += (char)('a' + (rand-10));
			}else if(rand<=61) {
				newPw += (char)('A' + (rand-36));
			}
		}
		return newPw;
	}
	
}
