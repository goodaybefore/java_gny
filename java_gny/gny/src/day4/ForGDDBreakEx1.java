package day4;

public class ForGDDBreakEx1 {
	public static void main(String[] args) {
		//두 정수의 최대공약수를 break로 작성
		
		int a=12;
		int b = 8;
		int max = a>b?a:b;
		//공약수를 큰 수 부터 구하기 시작해서 처음 구한 공약수를 출력하고 반복문을 종료
		for(int i=max;;i--) {
			if(a%i==0 && b%i==0) {
				System.out.println("최대공약수 :" +i);
				break;
			}
			
		}
	}

}
