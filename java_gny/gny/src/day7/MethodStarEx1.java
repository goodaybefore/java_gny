package day7;

public class MethodStarEx1 {

	public static void main(String[] args) {
		/* *****를 출력하는 메소드 만들고 호출
		 * */
		
		int num = 5;
		printStar(num);
		printChar(8,'*');
		printChar(5,'-');
		
		

	}
	public static void printStar(int num) {
		for(int i=0;i<num;i++) {
			System.out.print("*");
		}System.out.println();
	}
	
	public static void printChar(int num, char ch) {
		for(int i=0;i<num;i++) {
			System.out.print(ch);
		}
		System.out.println();
	}

}
