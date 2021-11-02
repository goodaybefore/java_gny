package day5;

public class StarEx1 {

	public static void main(String[] args) {
		/* 반복문으로 다음을 출력하는 예제를 작성
		 *  *****
		 *  *****
		 *  *****
		 *  *****
		 *  *****
		 *  반복횟수 : i는 1부터 5까지 1씩증가
		 *  규칙성 : i을 5번 출력
		 *  		반복횟수 : j는 1부터 5까지 1씩 증가
		 *  		규칙성 : j를 5번 출력 
		 */
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<5;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		

	}

}
