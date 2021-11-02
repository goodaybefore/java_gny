package day5;

public class PrintNumEx1 {

	public static void main(String[] args) {
		/*
		 * 1 2 3
		 * 4 5 6
		 * 7 8 9
		 */
		
		//방법1 : 3의 배수일때 엔터출력하기
		int i = 1;
		while(i<=9) {
			System.out.print(i+" ");
			if(i%3==0) System.out.println();
			i++;
		}
		
		System.out.println();
		//방법2 : cnt를 출력하기
		int cnt=1;
		for(i=1;i<=3;i++) {
			for(int j=1;j<=3;j++) {
				System.out.print(cnt+" ");
				cnt++;
			}
			System.out.println();
			
		}
		
		System.out.println();
		//방법3
		for(i=1;i<=3;i++) {
			for(int j=i*3-2;j<=3*i;j++) {
				System.out.print(j+" ");
			}System.out.println();
		}
		
		
		System.out.println();
		//방법4 :첫번쨰 for문의 i를 0으로 시작
		for(i=0;i<3;i++) {
			for(int j=i*3+1;j<=3*i+3;j++) {
				System.out.print(j+" ");
			}System.out.println();
		}
		
	}

}
