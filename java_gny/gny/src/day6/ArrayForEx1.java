package day6;

public class ArrayForEx1 {

	public static void main(String[] args) {
		// 

		int arr2[] = new int[5];
		for(int i=0;i<5;i++) {
			arr2[i] = 2*i +2;
		}
		
		/* 향상된 for문으로 바꾸기
		 * for(int i=0,sum2=0;i<5;i++) {
			sum2 += arr2[i];
		}*/
		
		int sum=0;
		for(int tmp:arr2) {
			sum += tmp;
		}
		
		System.out.println(sum);
		

	}

}
