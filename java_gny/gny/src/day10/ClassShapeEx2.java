package day10;

public class ClassShapeEx2 {

	public static void main(String[] args) {
		/* 타원을 나타내는 클래스를 생성하고
		 * 타원 클래스이ㅡ 객체를 만들고 테스트
		 * */
		Ellipse e1 = new Ellipse(0,0,10,10);
		e1.print();
		e1.move(10, 10);
		e1.print();
		e1.resize(5, 5);
		e1.print();

	}

}
