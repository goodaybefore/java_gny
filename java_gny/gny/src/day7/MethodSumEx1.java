package day7;

public class MethodSumEx1 {

	public static void main(String[] args) {
		
		int res = sum(1, 5);
		System.out.println("res : "+res);
		
		sum2(5,7);
		
	}
	
	/* 기능 : 두 정수의 합을 구하는 메소드
	 * public static 을 붙여서 메소드 선언(왜그러징)
	 * */
	public static int sum(int a, int b) {
		int sum = a+b;
		return sum;
	}
	
	
	//두 정수의 합을 콘솔에 출력하는 메소드
	public static void sum2(int a, int b) {
		System.out.println(a+" + "+b+" = "+(a+b));
	}

}
