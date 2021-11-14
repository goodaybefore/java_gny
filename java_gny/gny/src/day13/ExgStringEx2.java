package day13;

import java.util.Scanner;

public class ExgStringEx2 {
	public static void main(String[] args) {
		/* char charAt(int index) : 문자열에서 index 번째에 있는 문자를 알려주는 메소드*/
		String str = "Hello";
		System.out.println(str+"에서 첫번째 문자 : "+str.charAt(0));
		
		
		Scanner sc = new Scanner(System.in);
		
		//char ch = scan.next();//한 단어를 받아서 그 중 한 글자를 받아옴
		char ch1 = sc.next().charAt(0);
		char ch2 = sc.next().charAt(1);
		
		System.out.println("ch1 : "+ch1);
		System.out.println("ch2 : "+ch2);
		sc.close();
	}
}
