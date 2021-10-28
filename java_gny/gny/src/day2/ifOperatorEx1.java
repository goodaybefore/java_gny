package day2;

public class ifOperatorEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//조건연산자 사용한 A학점 확인
		int score=95;
		char isA = score <= 100 && score>90 ? 'Y':'N';
		System.out.println(score+"점은 A학점인가요? "+isA);
		
		//num1이 홀수이면 y, 짝수이면 n을 출력
		int num1 = 12;
		String isOdd = num1%2==1?"yes":"no";
		
		System.out.println(num1+"은 홀수인가요? "+isOdd);
		
		

	}

}
