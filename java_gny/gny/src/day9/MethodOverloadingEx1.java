package day9;

public class MethodOverloadingEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sum(1,2));

	}
	public static int sum(int num1, int num2) {
		return num1+num2;
	}
	
	//매개변수의 개수가 다른경우
	public static int sum(int num1, int num2, int num3) {
		return num1+num2+num3;
	}
	
	//매개변수의 타입이 다른경우
	public static double sum(double num1, double num2) {
		return num1+num2;
	}

	
	//오버로딩 안되는경우 : 리턴타입만 다른경우
//	public static int double(int num1, int num2) {
//		return num1+num2;
//	}
	
	
}
