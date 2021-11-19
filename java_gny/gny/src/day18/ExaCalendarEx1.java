package day18;
import java.util.Calendar;
public class ExaCalendarEx1 {
	//Calendar 클래스
	public static void main(String[] args) {
		/* Calendar : 요일, 년, 월, 일 정보들을 쉽게 확인할 때 사용
		 * 캘린더는 추상클래스 => 따라서 .getInstacne()로 호출해줘야함.
		 * 현재시간을 기준으로 객체를 만들어서 넘겨줌. new를 안 씀!
		 * 
		 * Calendar는 외부에서 객체를 만들지 못하고 내부적으로 만들어서 주기 때문에
		 * new 연산자가 아닌 getInstance() 메소드를 이용해야한다.*/
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		
		/* Calendar의 get메소드를 이용하여 년, 월, 일, 요일 등의 정보를 가져올 수 있다.. get으로 다 함 ㅇㅅㅇ
		 * 월은 0부터 시작해서 +1 해줘야함
		 * 요일 : 일요일부터 시작, 일요일 == 0
		 * HOUR : 12시간, HOUR_OF_DAY : 1~24시*/
		
		cal.set(Calendar.HOUR_OF_DAY, 14);//해당항목을 바꿔버림
		System.out.println(cal.get(Calendar.YEAR)+"년");//년도
		System.out.println(cal.get(Calendar.MONTH)+1+"월");
		System.out.println(cal.get(Calendar.DATE)+"일");
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		System.out.println(cal.get(Calendar.HOUR)+"시");
		System.out.println(cal.get(Calendar.HOUR_OF_DAY)+"시");
		System.out.println(cal.get(Calendar.MINUTE)+"분");
		System.out.println(cal.get(Calendar.SECOND)+"초");
		
		Calendar cal2 = Calendar.getInstance();//calendar는 내부에서 객체를 만들어서 줌
		System.out.println(cal2.get(Calendar.HOUR_OF_DAY)+"시");
		System.out.println(cal.get(Calendar.HOUR_OF_DAY)+"시");
		
		

	}

}
