package day9;

public class MethodArithmeticEx1 {

	public static void main(String[] args) {
		/* 두 정수와 산술연산자가 주어졌을 때 연산 결과를 출력하는 코드를 작성
		 * 단, 메소드 이용. 연산자는 무조건 산술연산자만 입력한다고 가정
		 * + - *  % */
		int num1=1, num2=2;
		char op = '/';
		System.out.println(""+num1+op+num2+"="+arthimetic(num1, op, num2));
		 

	}
	public static double arthimetic(int a, char arth, int b) {
		switch(arth) {
		case '+' : return a+b;
		case '-' : return a-b;
		case '*' : return a*b;
		case '/' : return (double)a/(double)b;
		case '%' : return a%b;
		default : return 0;
		}
	}
	
	/* 기능 : 두 정수와 산술연산자가 주어졌을 때 산술 연산 결과를 알려주는 메소드
	 * 
	 */

}
