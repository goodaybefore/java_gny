package day7;

public class MethodSumEx2 {

	public static void main(String[] args) {
		/*1~10합을 출력하는 코드를 메소드로
		 * 
		 * 방법 3개
		 * 방법1) 1부터 10까지의 합을 출력하는 메소드
		 * 방법2) 1부터 10까지의 합을 계산하는 메소드 - 
		 *  */
		int num = 10;
//		System.out.println("sum : "+sumNum(num));
		int begin=1, end=10;
		sumAll2(begin, end);
		
		
	}
	public static int sumNum(int num) {
		int sum = 0;
		for(int i=1;i<=10;i++) {
			sum += i;
		}
		return sum;
		
	}
	
	
	//방법1 : void타입
	//별로 안좋은 메소드
	public static void sumAll1() {
		int begin=1, end=10;
		int sum=0;
		for(int i=begin;i<=end;i++) {
			sum +=i;
		}
		System.out.println(begin+"부터 "+ end+ "까지의 합 : "+sum);
	}
	
	//방법2 : int 타입-> return sum
	public static void sumAll2(int begin, int end) {
		int sum = 0;
		for(int i=begin;i<=end;i++) {
			sum +=i;
		}
		System.out.println("sum : "+sum);
	}
	
	

}
