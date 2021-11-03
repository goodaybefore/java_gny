package day6;

import java.util.Arrays;

public class ArrayExpandEx1 {

	public static void main(String[] args) {
		//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★배열 확장
		//몰랐음!
		int score1[] = {100,90,94,60,40};
		int score2[] = new int[score1.length+10]; //score1의 확장을 위해 잠시 사용해주는 배열
		
		
		System.arraycopy(score1, 0, score2, 0, score1.length);
		score2[5] = 80;
		score1=score2;
		score2=null;//score2가 가리키는걸 null시켜줌
		
		System.out.println("score1");
//		for(int tmp:score1) {
//			System.out.print(tmp+" ");
//		}
		System.out.println(Arrays.toString(score1));//배열을 일렬로 출력할 수 있음!
		

	}

}
