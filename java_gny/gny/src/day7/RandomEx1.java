package day7;

import java.util.Random;

public class RandomEx1 {

	public static void main(String[] args) {
		/* 랜덤으로 원하는 범위의 정수를 만드는 예제
		 * 1. Math.random() : 0 이상 1 미만
		 * 	-> 0 <= Math.random()*(max-min+1) < max-min+1
		 * 	-> min <= Math.random()*(max-min+1+min) < max-min+1+min
		 * -> ★★★★★★★★★★★★ min <= Math.random()*(max+11) < max+1 ★★★★★★★★★★ 공식 외우기
		 * 2. Random Class에서 제공하는 nextInt(정수)
		 * 	-> 0 <=nextInt(max-min+1) <max-min+1
		 * 	-> min <= nextInt(max-min+1)+min < max+1
		 * */
		
		
		//Math.random()
		for(int i=0;i<5;i++) {
			System.out.print(Math.random()+" ");
		}
		
		System.out.println();
		//Random
		//Ctrl Shift 5 누르면 추가됨
		Random r = new Random();
		for(int i=0;i<5;i++) {
			System.out.print(r.nextInt(5)+" ");//0이상 5 미만의 랜덤한 숫자
		}
		
		System.out.println();
		System.out.println();
		int min=5, max=50;
		//1~10사이의 랜덤숫자를 만들고 싶다?
		for(int i=0;i<5;i++) {
			int random = (int)(Math.random()*(max-min+1)+min);
			System.out.print(random+" ");
		}
		
		System.out.println();
		for(int i=0;i<5;i++) {
			int random = r.nextInt(max-min+1)+min;
			System.out.print(random+" ");
		}
		
		
		
	}

}
