package day11;

public class FinalEx1 {
	public final static double PI=3.14;//왜 메인 이전에 선언하는지?
	public static void main(String[] args) {
		System.out.println(PI);
//		PI=3.141592;.//final상수를 수정하려했기때문에 에러발생
	}

}
final class Test11_1{
	
}
//Test11_1 은 final 클래스이기 때문에 상속받을 수 없다.
//class Test11_2 extends Test11_1{
//}
class Test11_3{
	public final void print() {
		
	}
}
class Test11_4 extends Test11_3{
	//final메소드를 오버라이딩 하려했기때문에 에러발생
//	@Override
//	public void print() {}
}