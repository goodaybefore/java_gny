package day4;

public class ForLCMEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 두 정수의 최소공배수
		 * a의 배수 : 어떤 정수를 a로 나누었을 때 나머지가 0인 수들
		 * 4의 배수 : 4, 8, 12, 16, 20 ...
		 * 6의 배수 : 6, 12, 18, 24, 30 ... 
		 */
		
		int a = 4, b =15;
		int min = a>b?b:a;
		for(int i=1;;i++) {
			int mulA = a*i;
			if(mulA%b==0) {
				System.out.println("최소공배수는 "+mulA);
				break;
			}
		}
		
		System.out.println();
		System.out.println("방법1");
		//방법1
		/* 무조건 1부터 시작하기 때문에 a와 b가 크면 불필요한 반복횟수가 많아짐
		 * 반복횟수 : i = 1~a*b 까지 증가
		 * 규칙성 : i가 a의 배수이고 i 가 b의 배수이면 i를 출력 후 반복문 종료
		 */
		for(int i=1;i<=a*b;i++) {
			if(i%a==0 && i%b==0) {
				System.out.println("최소공배수는 "+i);
				break;
			}
		}
		
		
		System.out.println();
		System.out.println("방법2");
		//방법2 : a부터 시작해서 a*b까지 a씩 증가
		/* 반복횟수 : i는 a부터 시작해서 a*b까지 a씩 증가
		 * 규칙성 : i가 b의 배수이면 i 출력 후 반복문 종료
		 */
		//a = 10000, b = 20000
		
		int num1 = 10000;
		int num2 = 20000;
		
		for(int j=num1;j<=num1*num2;j+=num1) {
			if(j%num2==0) {
				System.out.println("최소공배수는 "+j);
				break;
			}
		}
		
		
		

	}

}
