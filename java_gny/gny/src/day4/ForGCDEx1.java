package day4;

public class ForGCDEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//최대공약수구하기
		/*두 정수의 최대공약수를 구하는 코드를 for문으로 작성
		 * 12 : 1 2 3 4 6 12
		 * 8 : 1 2 4 8
		 * 약수 : 나누어서 떨어지는 수
		 * 공약수 : 두 정수의 약수 중 공통으로 있는 약수
		 * 8과 12의 공약수 : 1 2 4
		 * 최대공약수 : 두 정수의 공약수 중 가장 큰 수
		 * 8과 12의 최대공약수 : 4
		 * 
		 * 반복횟수 : i = 1부터 b까지
		 * 규칙성 : i가 8의 약수이고 i가 12의 약수이면 출력하기
		*/
		int a = 20;
		int b = 8;
		int smallNum = a>b?b:a;
		System.out.println("smallNum = "+smallNum);
		int GCD=0;
		for(int i=1;i<smallNum;i++) {
			if(a%i==0 && b%i==0 && GCD<i) {
				System.out.println(i);
				GCD = i;
			}
		}
		System.out.println("최대공약수는 "+GCD);

	}

}
