package day14;
//많이 쓰는 예제
public class ExcParseEx1 {
	
	public static void main(String[] args) {
		/* 정수를 문자열로 만드는 예제.*/
		int num = 10;
		
		//이러면 숫자가 문자가 됨 ㅇ0ㅇ 오웅
		String str = ""+num;
		System.out.println("정수 num : "+num);
		System.out.println("문자열 str : "+str);
		
		
		
		/* 문자열을 정수로 만드는 예제
		 * 래퍼 클래스인 Integer에서 제공하는 parseInt라는 메소드를 이용*/
		//예제1
		str = "1234";
		num = Integer.parseInt(str);
		System.out.println("str : "+str);
		System.out.println("num : "+num);
		
		
		/* 문자열을 정수로 바꿀 때 바꿀 수 없는 문자열이 있을 때 예외 발생
		 * 실수가 오는 경우 OR 문자가 오는 경우*/
		//예제2 : NumberFormatException 예외
//		num = Integer.parseInt("123.45");
//		num = Integer.parseInt("123a");
		System.out.println("예외 발생"); // 예외가 발생했을 때는 예외 밑에 있는 코드는 실행되지 않는다.
		
	}

}
