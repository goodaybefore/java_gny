package day14;

public class ExdExceptionEx1 {

	public static void main(String[] args) {
		/* 예외1 : ArithmeticException
		 *  - 어떤 정수를 0으로 나누는 동작을 하려 할 때 나타나는 예외
		 *  1 / 0은 ArithmeticException예외가 발생하는데
		 *  1.0/0은 예외가 발생하지 않음(Infinity 출력)*/
		int num1 = 1, num2 = 0;
//		int res = num1/num2;
//		System.out.println(num1+" / "+num2+" = "+res);
		
		double res2 = (double)num1/num2;
		System.out.println(num1+" / "+num2+" = "+res2);
		
		
		/* 예외2 : ArrayIndexOutOfBoundsException 
		 * 배열에서 잘못된 번지에 접근하는 경우 발생*/
		int array[] = new int[3];
//		array[3] = 0;
		
		
		/* 예외3 : NullPointerException 
		 * 참조변수(객체)가 null인 상태로 멤버변수 또는 메소드를 호출 할 때 발생*/
		String str = null;
		System.out.println(str.contains("Hello"));
		

	}

}
