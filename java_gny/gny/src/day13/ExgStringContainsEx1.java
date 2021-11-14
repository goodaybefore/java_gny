package day13;

public class ExgStringContainsEx1 {

	public static void main(String[] args) {
		//boolean contains(CharSequence s) : 문자열에 s가 포함되어있는지 알려줌
		String str1 = "Hello world";
		System.out.println(str1.contains("wo"));
		System.out.println(str1.contains("He"));
		System.out.println(str1.contains("Hi"));
	}

}
