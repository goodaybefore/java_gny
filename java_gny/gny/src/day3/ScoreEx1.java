package day3;

import java.util.Scanner;

public class ScoreEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 0~100사이의 점수를 입력받아 
		// 점수의 학점을 출력
		// 90~100 A
		// 80~90 B
		// 70~80 C
		// 60~70 D
		//~60 F
		
		System.out.println("점수입력 : ");
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		
		switch(score/10) {
		case 9,10:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		default:
			System.out.println("F");
			
		}
	}

}
