package day18;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExbDateEx1 {
	// Date 클래스
	// DB랑 연계가 쉬움? 
	public static void main(String[] args) {
		/* Date클래스 : 날짜 클래스
		 * 알아두면 스프링에서 많이만히 써먹음 
		 * */
		
		Date date1 = new Date();
		System.out.println(date1);
		
		
		/* data를 String으로 변환
		 * 예제 기억해두면 유용하게 활용
		 * 
		 * 년도 	: y
		 * 월	: M
		 * 일	: d
		 * 시	: H
		 * 분	: m
		 * 초	: s
		 * */
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str1 = format.format(date1);
		System.out.println(date1.getDay());//취소선 왜있지? => 옛날에는 썼던 메소드인데 최신버전에선 만료되어서 사용을 비추천한다~ 라는 뜻
		System.out.println(str1);
		
		
		format = new SimpleDateFormat("yyyy년 MM월 dd일");
		String str2 = format.format(date1);
		System.out.println(str2);
		
		/*String을 date로*/
		
//		Date date2 = format.parse(strDate1);//ㅃㄹ예외처리 하라고
		Date date2;
		try {
			String strDate1 = "2021-11-13 10:08:10";
			format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			date2 = format.parse(strDate1);
			System.out.println(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//ㅃㄹ예외처리 하라고
		
		

	}

}
