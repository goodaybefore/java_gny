package day14;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ExdTryCatchEx2 {

	public static void main(String[] args) {
		/* 두 정수와 산술연산자를 입력받아, 입력받은 산술연사자에 맞는 결과를 출력하는 코드를 작성*/
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 산술연산자 정수 입력");
		
		try{
			int a = sc.nextInt();
		
		char ch = sc.next().charAt(0);
		System.out.println(ch);
		int b = sc.nextInt();
		
		switch(ch){
		case '+': System.out.println(+a+" + "+b+" = "+(a+b)); break;
		case '-': System.out.println(+a+" - "+b+" = "+(a-b)); break;
		case '%':
			System.out.println(+a+" % "+b+" = "+(a%b));	break;
		case '/':
			System.out.println(+a+" / "+b+" = "+(a/(double)b));
			break;
		case '*': System.out.println(+a+" * "+b+" = "+(a*b)); break;
		default : System.out.println("계산할 수 없는 산술연산자");
		}
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다");
		}catch(InputMismatchException e) {
			System.out.println("입력을잘못하였습니다");
		}
		catch(Exception e) {
			
			System.out.println("예외발생");
			
		}

	}

}
