package day7;

import java.util.Arrays;
import java.util.Random;

public class ArryaRandomEx1 {

	public static void main(String[] args) {
		/*1~9 랜덤수를 생성해서 배열에저장하는코드*/
		
		int max=9, min=1;
		
		int arr1[] = new int[3];
		Random r = new Random();
		
		for(int i=0;i<3;i++) {
			arr1[i] = r.nextInt(max-min+1)+min;
		}
		System.out.println(Arrays.toString(arr1));
		
		
		int arr2[] = new int[3];
		for(int i=0;i<3;i++) {
			arr2[i] = (int)(Math.random()*(max-min+1)+min);
		}
		System.out.println(Arrays.toString(arr2));
	}

}
