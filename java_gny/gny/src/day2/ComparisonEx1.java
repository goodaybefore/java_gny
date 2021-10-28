package day2;

public class ComparisonEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//성인 판별 예제
		boolean isAdult;
		int age=25;
		isAdult = age>=19;
//		System.out.println(isAdult);
		
		//
		int num1 = 17;
		//true false
		
		boolean isEven = num1%2<1;
		boolean isOdd = num1%2==1;//!isEven
		System.out.println(num1+"은 짝수인가? " + isEven);
		System.out.println(num1+"은 홀수인가? " + isOdd);

	}

}
