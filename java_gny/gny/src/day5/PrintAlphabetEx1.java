package day5;

public class PrintAlphabetEx1 {

	public static void main(String[] args) {
		/* a
		 * ab
		 * abc
		 * abcd
		 * abcdef
		 * ...
		 * abc...xyz
		 * 의 코드작성
		 */
		
//		int cnt=1;
//		char ch='a';
//		for(int i=0;i<26;i++) {
//			for(int j=0;j<cnt;j++) {
//				System.out.print((char)(ch+j));
//			}System.out.println();
//			cnt++;
//		}
		

		//강사님방법
		/* 반복횟수 : ch는 a부터 z까지 1씩증가
		 * 규칙성 : a부터 ch까지 출력
		 * 		  반복횟수 : ch2는 a부터 ch까지 1씩증가
		 * 		  규칙성 : ch2를 출력
		 */
		
		char ch1, ch2;
		for(ch1='a';ch1<='z';ch1++) {
			for(ch2='a';ch2<=ch1;ch2++) {
				System.out.print(ch2);
			}System.out.println();
		}
	}

}



/*별 예제(숙제)
 * 
 * *****
 * ****
 * ***
 * **
 * *
 * 
 *  *****
 *   ****
 *    ***
 *     **
 *      *
 *      
 *      
 *   *  
 *  ***
 * *****
 *  ***
 *   *
 */
 