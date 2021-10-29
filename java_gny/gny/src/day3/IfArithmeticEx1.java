package day3;

import java.util.Scanner;

public class IfArithmeticEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//두 정수와 산술연산자 중 하나를 입력하여 입력한 연산자가 +이면 두 정수으ㅣ 합을 출력하는 코드를 작성
		//-이면 두 정수의 차이
		//곱하기이면 두 정수의 곱을
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 산술연산자 정수 입력");
		int a = sc.nextInt();
		char operator = sc.next().charAt(0);
		int b = sc.nextInt();
		
		if(operator=='+') {
			System.out.println(a+"+"+b+"="+(a+b));
		}else if(operator=='-'){
			System.out.println(a+"-"+b+"="+(a-b));
		}else if(operator=='/'){
			System.out.println(a+"/"+b+"="+((double)a/(double)b));
		}else if(operator=='*'){
			System.out.println(a+"*"+b+"="+(a*b));
		}else if(operator=='%'){
			System.out.println(a+"%"+b+"="+(a%b));
		}else {
			System.out.println("산술연산자가 아닙니다.");
		}
		
		
		sc.close();

	}

}
