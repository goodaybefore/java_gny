package day3;

import java.util.Scanner;

public class IfMultipleEx23 {

	public static void main(String[] args) {
		// 2 3 6의 배수 출력 (6의배수는 6의배수로 출력)
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if(num%2==0 && num%6 !=0) {
			System.out.println("2의 배수");
		}else if(num%3==0 && num%6!=0) {
			System.out.println("3의 배수");
		}else if(num%6==0) {
			System.out.println("6의 배수");
		}else {
			System.out.println("2 3 6의 배수가 아님");
		}

	}

}
