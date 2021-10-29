package day3;

public class ForEvenEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1~10까지 짝수만 출력하는 코드(방법3개)
		for(int i=1;i<=10;i++) {
			if(i%2==0) {
				System.out.println(i+"는 짝수");
			}//효율이 안좋음
		}
		
		
		//방법2 i는 1부터 5까지 X2해서 출력
		System.out.println();
		for(int i=1;i<=5;i++) {
			System.out.println((i*2));
		}
		
		//i는 2부터 10까지 2씩증가
		System.out.println();
		for(int i=2;i<=10;i+=2) {
			System.out.println(i);
		}

	}

}
