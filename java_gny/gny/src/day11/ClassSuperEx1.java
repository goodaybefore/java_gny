package day11;

public class ClassSuperEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child1 c1 = new Child1(1,2,3);
		c1.print();

	}

}
class Parent1{
	private int x, y;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void print() {
		System.out.println("Parent클래스입니다");
		System.out.println("x : "+x);
		System.out.println("y : "+y);
	}
	
	//기본생성자없이 x,y를 가지는 생성자를 생성
	public Parent1(int x, int y) {
		
		this.x = x; this.y = y;
	}
	public Parent1() {}
}

//클래스가 생성되면 기본생성자가 자동으로 생성되는데, 부모클래스에 기본생성자가 없으면
//부모클래스의 기본 생성자 super()가 자동으로 생성됨
/* 강사님설명)
 * 클래스안에 멤버변수, 메소드, 생성자가 하나도 없으면
 * 지동으로 기본 생성자가 생성되고,
 * 기본 생성자 안에 부모 클래스의 기본 생성자가 호출된다.
 * 이 때, 부모 클래스에 기본생성자가 없는 경우, 호출 할 수 없으므로 에러가 발생한다.
 * 
 * */
class Child1 extends Parent1{ //부모클래스에 "기본생성자"가 없으면 에러가 생김.
	
	private int z;//z축이라는 뜻
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}

	public Child1(int x, int y, int z) {
		/* 부모에게 물려받은 x y 를 매개변수 x y의 값으로 설정하려 할 때
		 * setter를 이용해서 할 수있지만, setter를 이용하는 것보다
		 * 부모 클래스에 이미 만들어져있는 생성자를 이용하는것이 편하다
		 * setX(x); setY(y);보다
		 * super(x,y)를 사용하는것이 편하다*/
		super(x,y);
		/* 그래서 자식클래스에 수퍼가 없으면 부모클래스에 수퍼가 추가된다
		 * 잘못하면 상속문 받아도 에러가 날 수 있다
		 * (먼말이지 이건)
		 * 
		 */
		this.z = z;
		
		//Parent1에 있는 print클래스를 Overriding하기
		//super 사용
		//위의 z 변수를 같이 출력하고 싶을 때
	}
	
	//부모에 있는 print를 이용하여 x y 를 출력하고 뒷부분(z)은 직접 출력
	@Override
	public void print() {
		super.print();
		System.out.println("z : "+z);
	}
	
	
}