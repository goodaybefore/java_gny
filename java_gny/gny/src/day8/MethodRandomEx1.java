package day8;

import java.util.Random;

public class MethodRandomEx1 {

	public static void main(String[] args) {
		/* `부터 10까지 난수생성하는 코드작성
		 * 랜덤한 수 메소드 사용
		 * */
		
		for(int i=0;i<10;i++) {
			System.out.println(makeRandom(1,10));
		}
		
		

	}
	public static int makeRandom(int begin, int end) {
		Random r = new Random();
		int rand  = r.nextInt(end-begin+1)+begin; 
		return rand;
	}

}
