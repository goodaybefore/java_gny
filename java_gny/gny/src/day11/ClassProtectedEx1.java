package day11;

public class ClassProtectedEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C c = new C();
		c.a = 1;//public : 모두 접근 가능
		
		//Q. ClassProtectedEx1은 P의 자식이 아닌데 왜 b는 에러가 안날까요?
		c.b = 2;//protected : 본인 + 자식클래스
		c.c = 3;//default : 본인 + 같은 패키지
//		c.d = 4;//해당 클래스만 접근 가능. P클래스만 접근 가능

	}

}
class P{
	public int a;//모두 접근
	protected int b;//같은패키지이면저 자식클래스여서 사용가능
	int c; //같은패키지라서 사용가능
	private int d;//P클래스가 아니라 다른데서 사용불가능
	
}

class C extends P{
	public C() {
		a = 1;
		b = 2;
		c = 3;
//		d = 4;
	}
}