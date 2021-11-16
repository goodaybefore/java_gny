package day15;

public class ExbFinallyEx1 {
//finally 사용법
	public static void main(String[] args) {
		/* 메소드 중간에 return이 있어서 중단되더라도
		 * 무조건 실행하고 넘어감
		 * */
		exceptionTest();

	}
	public static void exceptionTest() {
		int num1 = 1, num2 = 0;
		try {
			int res = num1/num2;
			System.out.println(res);
		}catch(Exception e){
			System.out.println("예외처리");
			return;
		}finally {
			System.out.println("finally");
		}
		System.out.println("메소드 마지막");
	}

}
