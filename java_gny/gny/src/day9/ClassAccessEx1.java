package day9;

public class ClassAccessEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
//		a.num1 = 10;//private :해당 클래스에서만 사용가능
		a.num2 = 20;//A클래스와 ClassAccessEx1 클래스가 같은 패키지에 있어서 사용가능
		a.num3 = 30; //어디서나 사용가능

	}

}

/*class앞에 public 붙이면 에러남
 * 왜? =>public class는 파일명과 같은 클래스에만 붙일 수 있음*/
class A{
	private int num1;
	int num2; //default : 접근제한자를 생략한 경우(기본)
	public int num3;
	
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	
	
	
}