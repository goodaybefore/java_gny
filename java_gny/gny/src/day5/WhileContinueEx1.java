package day5;

public class WhileContinueEx1 {

	public static void main(String[] args) {
		/* 1-10사이의 홀수 출력하기
		 * 
		 */
		
		//코드가 많아서 강사님이 좋아하는 스타일의 코드는 아님
		//방법1
		int i = 1;
		while(i<=10) {
			if(i%2==0) {
				i++;
				continue;}
			System.out.print(i+" ");
			i++;
		}
		
		
		System.out.println();
		//i++ 두번 안쓰고싶어
		//방법2
		i = 0;
		while(i<10) {
			i++;
			if(i%2==0) continue;
			System.out.print(i+" ");
		}
		
	}

}
