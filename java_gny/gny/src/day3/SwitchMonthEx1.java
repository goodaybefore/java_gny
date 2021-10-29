package day3;

import java.util.Scanner;

public class SwitchMonthEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int month = sc.nextInt();
		
		switch(month) {
		case 1,3,5,7,8,10,12:
			System.out.println(month+"월은 31까지");
			break;
		case 2:
			System.out.println(month+"월은 28까지");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println(month+"월은 30까지");
			break;
		default:
			System.out.println("존재하지않음");
		}

	}

}
