package day11;

public class ClassInitEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test11 t = new Test11();
		System.out.println(t.num);
		System.out.println(Test11.cnt);
	}

}
class Test11{
	/* 객체 멤버 변수 num의 초기화 순서
	 * 1. num=0 으로 초기화 : 자료형에 맞는 기본값으로
	 * 2. num=10 명시적 초기화
	 * 3. 초기화 블록에서 초기화
	 * 4. 생성자에서 초기화*/
	public int num = 10;
	
	//초기화블록
	{
	num=20;
	}
	
	//생성자에서 초기화
	public Test11() {
		num=30;
	}
	
	
	/* <스프링개발중에 크게 쓸 일은 없음>
	 * 클래스 멤버변수 cnt의 초기화 순서
	 * 1. cnt= 0 자료형의 기본값으로 초기화
	 * 2. 명시적 초기화(public static int cnt =11 <=요거 많이씀
	 * 3. cnt = 21로 초기화(초기화블록)*/
	public static int cnt=11;
	{
		cnt=21;
	}
	
}