package day12;


public class ExaTestEx1 {

	public static void main(String[] args) {
		/* ExaShape 테스트
		//ExaShape 도형만들기
		ExaShape s1 = new ExaShape(0, 0, 10, 10);
		s1.print();
		ExaShape s2 = new ExaShape(10, 10, 0, 0);
		s2.print();
		
		
		//와나 ㅋㅋ 안됨
		//move에서 this.left+right를 해줘야했어요~ 작은이슈가 있었어요~~~^^*
		s2.move(10, 10);
		s2.print();
		
		//이것도 안됨 키키
		s2.resize(20, 20, 3);
		s2.print();
		s2.resize(10, 10, 2);
		s2.print();
		s2.resize(5, 5, 1);
		s2.print();
		s2.resize(3, 3, 4);
		*/
		
		
		//사각형 클래스(ExaRect) 테스트
		ExaRect r1 = new ExaRect(10,10,0,0);
		r1.print();
		r1.move(10, 10);
		r1.print();
		r1.resize(15, 20, 1);
		r1.print();
//		
		
		/*타원 클래스(Ellipse) 테스트*/
		ExaEllipse e1 = new ExaEllipse(10,10,0,0);
		e1.print();
		
		
	}

}
