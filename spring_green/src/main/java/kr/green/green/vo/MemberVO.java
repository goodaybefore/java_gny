package kr.green.green.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberVO {
	private String me_id;
	private String me_pw;
	private String me_name;
	private String me_gender;
	//sette의 매개변수에 문자열이 오는 경우 이렇게 지정
	//getter는 그냥 지정(BoardVO참고)
	
	//setter가 필요한 경우 : 화면에서 정보를 전달받을 때.
	//ex.del_date, up_date; => db에 자동으로 들어가기 때문에 data type 이 필요없음
	//memverVo에서 필요한 이유 : 화면에서 전달해주는건 문자열이기 때문에 DateTimeFormat이 필요 
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date me_birth;
	
	private String me_address;
	private String me_phone;
	private String me_authority;
	private String me_email;
	
	
	public String getMe_birth_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(me_birth);
	}
	/*
	//birth Date 처리
	//java day18 Date클래스 - ExbDateEx1
	//이거를 위쪽의 @DateTimeFormat(pattern="yyyy-mm-dd") 한줄로 대체가능
	public void setMe_birth(String me_birth) {
		SimpleDateFormat format;
		try {
			format = new SimpleDateFormat("yyyy-MM-dd");
			this.me_birth = format.parse(me_birth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}*/
}
