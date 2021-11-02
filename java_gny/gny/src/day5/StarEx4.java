package day5;

public class StarEx4 {

	public static void main(String[] args) {
		/* 방법1
		 *     *     i=1 공백=4 *=1
		 *    ***	 i=2 공백=3 *=3
		 *   *****	 i=3 공백=2 *=5
		 *  *******	 i=4 공백=1 *=7
		 * ********* i=5 공백=0 *=9
		 * 				 공백=5-i
		 * 
		 * 방법2
		 *     *     i=1 공백=4 *=1
		 *    ***	 i=2 공백=3 *=2
		 *   *****	 i=3 공백=2 *=3
		 *  *******	 i=4 공백=1 *=4
		 * ********* i=5 공백=0 *=5
		 * 				 공백=5-i
		 */
		
		//방법1
//		for(int i=1;i<=5;i++) {
//			for(int j=5;j>i;j--) {
//				System.out.print(" ");
////				System.out.print(j);
//				}
//			for(int k=1;k<=(i*2)-1;k++) {
//				System.out.print("*");
//			}
//			
//			System.out.println();
//		}
		
		
		//방법2 : StarEx3의 예제를 활용
		for(int i=1;i<=5;i++) {
			for(int j=5;j>i;j--) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				System.out.print("*");
			}
			for(int l=1;l<=i-1;l++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
		
		//강사님 방법1(while사용)
		int num=5;
		int i=1;
		while(i<=num) {
			int j=1;
			while(j<=num-i) {
				System.out.print(" ");
				j++;
			}
			while(j<=2*i-1) {
				System.out.print("*");
				i++;
			}
		}

	}

}
