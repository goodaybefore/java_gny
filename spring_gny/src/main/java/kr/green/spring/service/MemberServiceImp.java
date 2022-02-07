package kr.green.spring.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public MemberVO login(MemberVO member) {
		if(member == null || member.getMe_id() == null) return null;
		MemberVO Dbuser = memberDao.getMember(member.getMe_id());
		//System.out.println("member : "+member);
		//System.out.println("dbUser: "+Dbuser);
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

	@Override
	public MemberVO updateMember(MemberVO input, MemberVO user) {
		if(input == null || user == null) return null;
		if(input.getMe_name()==null
				|| input.getMe_birth()==null
				|| input.getMe_gender()== null) return null;
		
		input.setMe_id(user.getMe_id());
		
		//비번을 입력안한경우
		if(input.getMe_pw()==null || input.getMe_pw().length() == 0) { 
			input.setMe_pw(user.getMe_pw());
		} else {
			String encPw = passwordEncoder.encode(input.getMe_pw());
			input.setMe_pw(encPw);
		}
		
		
		if(input.getMe_address()==null || input.getMe_address().length()==0)
			input.setMe_address(input.getMe_address());
		
		System.out.println("user : "+ user);
		System.out.println("input : " + input);
		memberDao.updateMember(input);
		
		return input;
		
	}
	
	//회원 찾기 - ID
	@Override
	public String findId(MemberVO member) {
		if(member == null) return "";
		MemberVO user = memberDao.findMember(member);
		if(user == null) return "";
		return user.getMe_id();
		
	}

	@Override
	public String findPW(MemberVO member) {
		//예외처리
		if(member == null) return "false";
		//회원정보 가져옴
		MemberVO user = memberDao.getMember(member.getMe_id());
		//회원정보 없으면 종료
		if(user == null || !user.getMe_email().equals(member.getMe_email())) {
			System.out.println("user.getMe_email() : "+user.getMe_email());
			System.out.println("member.getMe_email() : "+member.getMe_email());
			return "false";
		}
		
		//임시 비번 생성 - n자리의 숫자만큼의 랜덤한 비밀번호를 생성해주겠다
		String newPw = createRandomPw(6);
		String encPw = passwordEncoder.encode(newPw);
		//생성된 임시 비번을 DB에 저장
		user.setMe_pw(encPw);
		memberDao.updateMember(user);
		
		//이메일로 새 비번 전송(암호화되지않은 비번 전송)
		String setfrom = "stajun@naver.com";         
	    String tomail  = member.getMe_email();     // 받는 사람 이메일
	    String title   = "새 비밀번호";      // 제목
	    String content = "새 비밀번호는 "+newPw+ "입니다.";    // 내용

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
	        return "error";
	    }
		
		return "true";
	}

	private String createRandomPw(int maxSize) {
		String newPw = "";
		//maxSize 개수로 이루어진 비번을, 영어와 숫자로 이루어짐
		//a~z, A~Z, 0~9 : 62개
		//0~61사이의 랜덤한 수를 maxsize개수만큼 생성
		for(int i=0;i<maxSize;i++) {
			int max = 61, min = 0;
			int rand = (int)(Math.random()*(max-min+1)+min);
			//int rand = (int)(Math.random()*62);
			
			//랜덤 수가 0~9이면 문자 0~9
			if(rand>=0 && rand<=9) {
				newPw += (char)('0' + rand);
			}else if(rand <= 35) {
				newPw += (char)('a'+(rand - 10));
			}else if(rand <= 61) {
				newPw += (char)('A'+(rand - 36));
			}
		}
		
		
		//랜덤 수가 10~35이면 문자 a~z
		//랜덤 수가 36~61이면 문자 A~Z
		return newPw;
	}
	
}
