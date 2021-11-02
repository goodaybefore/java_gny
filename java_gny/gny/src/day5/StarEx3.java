package day5;

public class StarEx3 {

	public static void main(String[] args) {
		/*     * i=1 space=4 *=1 엔터
		 *    ** i=2 space=3 *=2 엔터
		 *   *** i=3 space=2 *=3 엔터
		 *  **** i=4 space=1 *=4 엔터
		 * ***** i=5 space=0 *=5 엔터
		 * 
		 * 반복횟수 : i는 1부터 5까지 1씩 증가
		 * 실행문 : 공백을 5-i개 출력 / 별을 i개 출력하고 엔터
		 * 
		 * 		반복횟수 : j는 1부터 5-i까지 1씩 증가
		 * 		실행문 : 공백을 출력
		 * 
		 * 		반복횟수 : j는 1부터 i까지 1씩 증가
		 * 		실행문 : *을 출력
		 * 
		 * 	엔터를 출력
		 */
		
		int num=5;
//		for(int i=1;i<=num;i++) {
//			for(int j=num;j>i;j--) {
//				System.out.print(" ");
//			}
//			for(int k=1;k<=i;k++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		
		//강사님 방법
		num = 5;
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
	}
}
