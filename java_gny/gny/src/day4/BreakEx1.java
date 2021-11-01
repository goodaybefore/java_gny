package day4;

public class BreakEx1 {

	public static void main(String[] args) {
		/* 반복문에서 break문이 if문과 같이 써야하는지를 보여주는예제
		 * 
		 */
		//1~5 break이용하여 출력
		for(int i=1;;i++) {
			System.out.println(i);
//			break;//한번만 실행됨
			if(i==5) break;
		}
		

	}

}
