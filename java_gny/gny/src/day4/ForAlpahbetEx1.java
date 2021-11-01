package day4;

public class ForAlpahbetEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 문자에 숫자를 더하는경우
		 * 문자 + 숫자를 하면 문자에 맞는 유니코드 값에서 1을 더한다
		 * 'a' = 97 , 'a' + 1 = 98
		 * 이 값을 문자로 변환하면 해당 유니코드 값에 맞는 문자 'b'가 된다
		 * */
		char ch1 = 'a';
		int num = 1;
//		char ch2 = ch1 + 1; 자료형변환문제 / 98이긴한데 (int)98이라 자료형이 맞지않음
		char ch2 = (char)(ch1+1);
		
		char ch3 = 'a' + 1;
		// 아스키코드상에서 a 다음꺼를 가리킴.
		//a는 아스키코드에서 97, 따라서 'a'+1 하면 98번인 b를 가리킴
		//여기서 1 ->리터럴상수
		//리터럴상수끼리는 자료형변환이 일어나지 않음.
		
//		char ch4 = ch1 + num; 자료형변환문제 / 98이긴한데 (int)98이라 자료형이 맞지않음
		char ch4 = (char)(ch1 + num);
		
		
		
		
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(ch3);
		System.out.println(ch4);
	}

}
