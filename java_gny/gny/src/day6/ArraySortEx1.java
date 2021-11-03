package day6;

import java.util.Arrays;
import java.util.Collections;

public class ArraySortEx1 {

	public static void main(String[] args) { 
		
		int num[] = {1, 10, 9, 3, 6, 2, 3, 4};
		/* 이와 같은 배열이 있을 때 정렬하는 코드를 작성하세요
		 * 버블정렬 : 옆에 있는 값과 비교하여 정렬하는 방법
		 * */
		// 내가푼거 //
		int tmp = 0;
		for(int i=0;i<num.length-1;i++) {//Q. 한번밖에 정렬이 안됨.. 여러번 해야하는데 여러번 하는 조건식을 어떻게 적어야할까
			if(num[i]>num[i+1]) {
				tmp = num[i];
				num[i] = num[i+1];
				num[i+1] = tmp;
			}
		}
		
		//강사님
//		for(int i=0;i<num.length-1;i++) { //A. 그냥 반복문 한번 더 해주면 되는거였음....
//			for(int j=0;j<num.length-1;j++) {
//				/* j=0일때 1,9 / j=1일때 9,3 / j=2일때 3,6 / j=3일때 6,2 / j=4일때 2,3 / j=5일때 3,4 / j=6일때 4,10 이렇게 봐줘야 하기 때문에
//				 * 조건식을 num.length-1을 해주는 것임.*/
//				
//				if(num[j]>num[j+1]) {
//					int x = num[j];
//					num[j] = num[j+1];
//					num[j+1] = x;
//				}
//			}
//		}
		
		
		//java에서 제공하는 버블sort기능
		Arrays.sort(num);//오름차순으로 자동정렬
//		Arrays.sort(num, 0, 5);//0번째부터 5번째 까지 오름차순으로 정렬
		
		System.out.println("num");
		for(int temp:num) {
			System.out.print(temp+" ");// 1 9 3 6 2 3 4 10
		}
		

	}

}
