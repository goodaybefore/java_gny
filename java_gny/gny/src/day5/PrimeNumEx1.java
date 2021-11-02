package day5;

public class PrimeNumEx1 {

	public static void main(String[] args) {
		// 소수 구하는 예제
		/* 2부터 100이하의 모든 소수를 출력
		 * 
		 */
		
		//for문으로
		for(int num=2;num<=100;num++) {
			int cnt = 0;
			for(int j=1;j<=num;j++) {
				if(num%j==0) cnt++;
			}
			if(cnt==2) System.out.print(num+" ");
		}
		System.out.println();
		
		
		//while문으로
		int num=1, cnt, j;
		while(num<=100) {
			cnt=0;
			j=1;
			while(j<=num) {
				if(num%j==0) cnt++;
				j++;
			}
			if(cnt==2) System.out.print(num+" ");
			num++;
		}
		
		
		System.out.println();
		//for_while문으로
		for(num=1;num<=100;num++) {
			j=1;
			cnt=0;
			while(j<=num) {
				if(num%j==0) cnt++;
				j++;
			}
			if(cnt==2) System.out.print(num + " ");
		}
		
		
		
	}

}
