package day7;

import java.util.Arrays;
import java.util.Random;

public class ArrayRandomEx2 {

	public static void main(String[] args) {//★★★★★★★★★★★★★★★★★★★★★★★★★★어려웟
		/*1 ~ 9사이의 중복되지 않는 랜덤한 세 숫자*/
		
		//중복된거 나옴...뭐가문제지ㅜ
		int min=1,max=3;
		Random r = new Random();
		int arr[] = new int[3];
//		for(int i=0;i<3;i++) {
//			arr[i] = r.nextInt(max-min+1)+min;
//			boolean overlap=true;
//			int num=0;
//			while(overlap) {
//				if(arr[num]==arr[i]) {
//					arr[i] = r.nextInt(max-min+1)+min;
//					num++;
//				}else {
//					overlap = false;
//				}
//				
//			}
//		}
//		System.out.println(Arrays.toString(arr));
		
		
		
		int arr2[] = new int[3];
		int count =0;
		do {
			int rand = r.nextInt(max-min+1)+min;
			int i;
			/* count = 0일때 반복문 실행 안됨 => i=0 => rand 저장 후 count++;
			 * count = 1일때 반복문 실행
			 * 		1) 중복된 수가 있다면? count=1일때 i=0
			 * count = 2일때 반복문 실행
			 * 		1) 중복된 수가 있다면? count=2일때 i는 0 or 1
			 * 
			 * */
			for(i=0;i<count;i++) {//★★★★★★★★★★★저장되어있는 개수만큼만 확인하면 되니까 i<count
				if(arr2[i] == rand) break;//중복된 수 있으면 반복문 중단
			}
			if(i==count) {
				arr2[i] = rand;
				count++;
			}
		}while(count!=3);
		
		System.out.println(Arrays.toString(arr2));
		
		
	}

}
