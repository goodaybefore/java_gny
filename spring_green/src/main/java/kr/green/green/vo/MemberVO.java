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
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date me_birth;
	private String me_address;
	private String me_phone;
	
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
