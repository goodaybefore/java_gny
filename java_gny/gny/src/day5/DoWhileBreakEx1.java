package day5;

import java.util.Scanner;

public class DoWhileBreakEx1 {

	public static void main(String[] args) {
		//0 ㅇ비력 시 입력 종료하는거
		
		Scanner sc = new Scanner(System.in);
		int num=0;
		for(;num!=0;) {
			System.out.println("정수입력");
			num = sc.nextInt();
		}
		System.out.println("do while문");
		do {
			num = sc.nextInt();
		}while(num !=0);
		

	}

}
