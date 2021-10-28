package day2;

import java.util.Scanner;

public class ScannerEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//두 정수를 입력받아 합을 구하기
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 두개 입력하세요 ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println("a+b = "+(a+b));
		
		double divRes = (double)a/(double)b;
		System.out.println("두 수의 합을 나눈 결과 :"+divRes);
		
		sc.close();
		

	}

}
