package day12;

public class ExbEqualsEx2 {

	public static void main(String[] args) {
		//문자열 비교해보기
		/* 문자열을 초기화 할 때 리터럴문자열(상수문자열, "Hello" "1" "2" "C"처럼 정해져있는 문자열)로 초기화하면
		 * 리터럴 상수만 저장하는 장소에 객체를 생성함
		 * 
		 * 설명을 위한 선언)
		 * int num =1; //=> 컴퓨터 메모리 일부에 상수만 접근(메모리를 할당)할 수 있는 공간이 있음.
		 * 그래서 int num을 선언하면 그 공간 안 어딘가에 1이 생기고 공간 바깥에 num이라고 이름을 붙임
		 * 나중에 1이 필요하면 1이 생긴곳에서 1을 복사해서 넣어줌
		 * int num2 = 1;을 선언하면 num2를 만든 후에 이미 만들어져있는 1을 가쥬와서 씀. 새로 1을 쓰지 X
		 * 이와 마찬가지로 str1 과 str3도 동일하게 동작됨.
		 * 리터럴 상수로 선언한 str1이 있으면 "Hello"를 저장. str3을 "Hello"로 선언하면 str3을 그대로 가져온것
		 * But str2 = new String("Hello");
		 * //이건 똑같이 Hello를 가져오긴 한데... str2는 객체를 생성한 것이므로 바깥공간 어딘가에 "Hello"를 저장하고,
		 *	 str2는 그 Hello를 가진 주소를 저장하고 있는 것. 결국은 주소가 달라서 str1 != str2가 되는것.
		 *
		 * */
		
		
		String str1 = "Hello";
		String str2 = new String("Hello");
		String str3 = "Hello";
		
		
		//==로 비교
		//str1==str3, str1==str3!=str2
		if(str1 == str2) {
			System.out.println("== : 두 문자열이 같다?");
		}else {
			System.out.println("== : 두 문자열이 다르다?");
		}
		if(str1 == str3) {
			System.out.println("== : 두 문자열이 같다?");
		}else {
			System.out.println("== : 두 문자열이 다르다?");
		}
		
		System.out.println("====이 밑은 equals로 비교한다====");
		//equals로 비교
		if(str1.equals(str2)) {
			System.out.println("== : 두 문자열이 같다?");
		}else {
			System.out.println("== : 두 문자열이 다르다?");
		}
		if(str1.equals(str3)) {
			System.out.println("== : 두 문자열이 같다?");
		}else {
			System.out.println("== : 두 문자열이 다르다?");
		}
		

	}

}
