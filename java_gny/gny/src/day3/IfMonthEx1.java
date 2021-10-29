package day3;

import java.util.Scanner;

public class IfMonthEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//월을 입력받아 입력받은 월의 마지막 일을 출력하는 코드를 작성하세요
		//단, 2월은 28일
		Scanner sc = new Scanner(System.in);
		System.out.println("궁금한 달 입력");
		int month = sc.nextInt();
		
		if(month>12) {//month가 12초과일때
			System.out.println("존재하지 않는 달 입니다");
		}else if(month == 2) {// 28일때
			System.out.println(month+"월은 28일까지");
		}else if((month<8 && month%2==1)||(month>=8 && month%2==0)) {//31일때
			System.out.println(month+"월은 31일까지");
		}else if((month<8 && month%2==0)||(month>=8 && month%2==1)) {//30일때
			System.out.println(month+"월은 30일까지");
		}
	}

}
