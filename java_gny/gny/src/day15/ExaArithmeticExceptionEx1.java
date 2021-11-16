package day15;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ExaArithmeticExceptionEx1 {

	public static void main(String[] args) {
		//★★★★★밑에 중요쓰
		/* 두 정수와 산술연산자 입력받구 산술연산결과 출력
		 * 단 메소드를이용해서 예외처리*/
		try {
			Scanner sc =  new Scanner(System.in);
			int a = sc.nextInt();
			char op = sc.next().charAt(0);
			int b = sc.nextInt();
			
			double res = arith(a,op,b);
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}catch(InputMismatchException e) {
			System.out.println("제대로 입력하세요.");
		}catch(Exception e) {
//			System.out.println(e.getMessage());//★★★★e.getMessage()중요
			e.printStackTrace();
		}finally {
			System.out.println("마지막코드1");
		}
		System.out.println("마지막코드2");
	}
	public static double arith(int a, char op, int b) throws Exception {
		double res;
		switch(op){
		case '+': System.out.println(+a+" + "+b+" = "+(a+b)); res = a+b; break;
		case '-': System.out.println(+a+" - "+b+" = "+(a-b)); res = a-b; break;
		case '%': System.out.println(+a+" % "+b+" = "+(a%b)); res = a%b; 
		//예외처리
		break;
		case '/': System.out.println(+a+" / "+b+" = "+(a/(double)b)); res = (a/(double)b); break;
		case '*': System.out.println(+a+" * "+b+" = "+(a*b)); res = a*b; break;
		default : throw new Exception("잘못된 연산자입니다");//★★★★★★★★★★★
		}
		return res;
	}
}
