package day4;

import java.util.Scanner;

public class ForPrimeEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*입력받은 정수가 소수인지 아닌지 판별하는 코드
		 * For문 사용
		 */
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 0;
		for(int i=1;i<=num;i++) {
			if(num%i==0) {
				count++;
				System.out.print(i+" ");
			}
		}
		System.out.println();
		if(count==2) {
			System.out.println(num+"은(는) 소수입니다.");
			
		}else{
			System.out.println(num+"은(는) 소수가 아닙니다");
		}
		
		
		//Switch문
		System.out.println();
		System.out.println("스위치문");
		switch(count) {
		case 2: System.out.println("소수 맞음");break;
		default: System.out.println("소수 아님"); break;
		}
		
		
		//조건연산자
		System.out.println();
		System.out.println("조건연산자");
		String str = count == 2 ? "소수":"소수아님";
		System.out.println(num+"은 "+str);
		
		
		
		
		sc.close();
	}

}
