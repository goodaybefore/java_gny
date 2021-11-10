package day11;

public class ClassRectEx1 {

	public static void main(String[] args) {
		/**/
		Rect r1 = new Rect();
		r1.print();
		Point p1 = new Point(0,0);
		Point p2 = new Point(10,10);
		Rect r2 = new Rect(p1,p2);
		r2.print();
		r2.move(10, 10);
		r2.print();
		r2.resize(5,15);
		r2.print();
		
		//0,0이 아닌 10,10이 됨.
		//r2만들때 공유했기 때문
		p1.print();
		
		//이러면 사각형 모양까지 바뀜
		p1.move(15, 20);
		r2.print();
		//이러한 문제를 막기위해 "복사생성자"를 만들어야함
		
	}

}
