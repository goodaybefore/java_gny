package day7;

public class MethodVariableEx1 {

	public static void main(String[] args) {
		/**/
		int num1 = 10, num2= 20;
		System.out.println("main 메소드 > a : "+num1+", b : "+num2);
		int res = sum(num1, num2);
		System.out.println("main메소드 > a : "+num1+", b : "+num2);

	}
	public static int sum(int a, int b) {
		System.out.println("sum메소드 > a : "+a+", b : "+b );
		int tmp = a;
		a = b;
		b = tmp;
		System.out.println("sum메소드 > a : "+a+", b : "+b );
		return a+b;
	}

}
