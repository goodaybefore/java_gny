package day14;

public class ExdTryCatchEx1 {

	public static void main(String[] args) {
		/* try ~ catch문을 이용한 예외처리*/
		int num1 = 1, num2 = 0;
		int res;
		try {
			res = num1/num2;
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException 예외 - 잘못된 번지로 배열에 접근");
		}catch(ArithmeticException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());//왜 에러발생했는지 알려줌
			System.out.println("ArithmeticException 예외 - 0으로 나눔");
		}catch(Exception e) {
			System.out.println("아무튼 예외임");
			
		}
		System.out.println("프로그램종료");

	}

}
