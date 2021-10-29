package day3;

import java.util.Scanner;

public class IfMultipleEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//입력받은 정수가 2의 배수이면 2의배수출력 아니면 아니라고출력
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력하세요");
		int a = sc.nextInt();
		if(a%2==0) {
			System.out.println("2의 배수입니다");
		}else {
			System.out.println("2의 배수가 아닙니다");
		}
	}

}
