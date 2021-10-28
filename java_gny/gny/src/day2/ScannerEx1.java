package day2;

import java.util.Scanner;

public class ScannerEx1 {

	public static void main(String[] args) {
		// 콘솔에서 입력 받을 수 있게 스캐너를 생성
		// 생성된 스캐너의 이름은 scan 
		Scanner scan = new Scanner(System.in);
//		System.out.print("정수를 입력하세요 ");
//		int num = scan.nextInt();
//		System.out.println("입력한 정수는 "+num+" 입니다.");
//		
//		System.out.print("실수를 입력하세요 ");
//		double num2 = scan.nextDouble();
//		System.out.println("입력된 실수는 "+num2+" 입니다.");
//		
//		System.out.print("문자를 입력하세요 ");
//		char ch1 = scan.next().charAt(0);
//		System.out.println("입력된 문자는 "+ch1+" 입니다.");
		
		//문자열 입력받는 방법(2가지)
		//첫번째
		System.out.print("단어를 입력하세요 ");
		String str1 = scan.next();//next() <<- 공백을 제외한 첫번째 단어를 읽어옴
		System.out.println("입력된 단어는 "+str1+" 입니다.");
		
		//★★★★★★★★★★★★★★★★★★★★★★★★
		scan.nextLine();//이렇게 해주면 string 못읽지 않음 암기필★★★★★★★★★
		
		
		//두번째 - 공백포함읽기
		System.out.print("문장을 입력하세요 ");
		String str2 = scan.nextLine();
		System.out.println("입력된 문장은 "+str2+" 입니다.");
		
		//더이상 입력받을 내용이 없으면 스캐너 사용 종료
		scan.close();

	}

}
