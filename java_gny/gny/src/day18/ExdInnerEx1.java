package day18;
//내부클래스
//개념정도만 기억해도 ㄱㅊ
//기존에 만들어진 클래스 중에 이너클래스가 들어간 클래스가 있다는 것만 알아두기
public class ExdInnerEx1 {

	public static void main(String[] args) {
		/* public static 이너클래스랑 그냥 public 차이 */
		
		A.InnerB b = new A.InnerB();//한줄로 끝남
				
		
		A a = new A();
		A.InnerD d = a.new InnerD();//a를 선언하고 d를 한번 더 해줘야함(2줄.. 불편..)
		
		
		

	}

}
class A{
	public class InnerD{
		
	}
	public static class InnerB{
		
	}
	private class InnerC{
		public int num=10;
	}
	public void test() {
		InnerC c = new InnerC();
		c.num = 20;
		System.out.println(c.num);
	}
}
