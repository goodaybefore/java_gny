package day4;

import java.util.Scanner;

public class ForBreakEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//0을 입력할때까지 정수를 계속 입력받는 코드를 작성하세요
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=1;;i++) {
			System.out.print("정수를 입력하세요 : ");
			int a = sc.nextInt();
			if(a==0)break;
		}
		

	}

}
