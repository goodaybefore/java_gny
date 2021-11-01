package day4;

public class ForAlpahbetEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* a~z까지 출력하는 코드를 For문으로 작성
		 * 
		 */
		
		for(int i = 97;i<=122;i++) {
			char cha = (char)i;
			System.out.print(cha);
		}
		
		
		
		
		
		
		/* 방법1
		 *  반복횟수 : i=0부터 26보다 작을 때까지 1씩증가
		 *  규칙성 : 문자 'a'+1을 출력
		 *  
		 *  방법2
		 *  반복횟수 : ch는 'a'부터 'z'까지 1씩증가
		 *  규칙성 : ch를 출력
		 */
		System.out.println();
		
		//방법1
		for(int i =0;i<26;i++) {
			//char cha2 = (char)('a' + i);
			System.out.print((char)('a'+i));
			}
		
		//방법2
		System.out.println();
		char ch = 'a';
		for(ch='a';ch<='z';ch++) {
			System.out.print(ch);
		}
	}

}
