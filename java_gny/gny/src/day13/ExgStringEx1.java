package day13;

public class ExgStringEx1 {

	public static void main(String[] args) {
		/* 문자열 String의 객체 생성 방법
		 * 1. "",를 이용
		 * 2. new String 사용*/
		String str1 = "Hi";
		String str2 = new String("Hi");
		/* str1과 str3는 Hi라는 문자열(A지점에 있음)을 공유
		 * str2는 B지점에 있는 문자열사용*/
		String str3 = "Hi";
		
		System.out.println("str1과 str2의 주소가 같나요? "+(str1==str2));
		System.out.println("str1과 str3의 주소가 같나요? "+(str1==str3));
		System.out.println("str2와 str3의 주소가 같나요? "+(str2==str3));

		
		System.out.println("str1과 str2의 문자열이 같나요? "+(str1.equals(str2)));
		System.out.println("str1과 str2의 문자열이 같나요? "+(str1.equals(str3)));
		System.out.println("str1과 str2의 문자열이 같나요? "+(str2.equals(str3)));
	}

}
