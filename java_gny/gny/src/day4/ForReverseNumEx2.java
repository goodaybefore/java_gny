package day4;

public class ForReverseNumEx2 {

	public static void main(String[] args) {//★★★★★★★★중요(힌트 보기 전까지 못풀었음)
		// TODO Auto-generated method stub
		/* 정수를 역순으로 출력하는 코드를 FOR문으로 작성
		 * 예) 1234 => 4321
		 * 
		 * 반복횟수 : num가 0이 아닐때까지
		 * 규칙성 : num을 10으로 나눈 나머지를 출력
		 *		num/10을 num에 저장
		 */
		
		
		//1의자리 출력
//		System.out.println(num%10);
		
		for(int num = 1234;num!=0;num = num/10) {
			//1. 들어온 숫자의 일의자리를 찾기위해 num%10을 해줌
			//2. 다음 자리 수를 찾기 위해 num/10
			System.out.print(num%10);
//			num = num-num%10;//큰역할X 걍빼기
			
		}
		
		System.out.println();
		//초기화와 증감식은 생략해도됨
		int n=1123;
		for(;n!=0;) {
			System.out.print(n%10);
			n = n/10;
		}

	}

}
