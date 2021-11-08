package day9;

public class ClassEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point2D p = new Point2D();
		System.out.println("("+p.x+", "+p.y+")");
		Point2D p2 = new Point2D(1, 3);
		System.out.println("("+p2.x+", "+p2.y+")");
		p2.print();
		p2.move(10, 20);
		p2.print();
		
	}

}


//좌표평면에서 점 하나를 나타내기위한 클래스 point2D를 만들어보세요
/* 클래스명 : point2D
 * 멤버변수 : 점 하나 => x좌표 y좌표
 * 멤버메소드 : 현재 좌표정보를 출력하는 메소드
 * 		   : 지정된 좌표(누군가 알려준)로 이동하는 메소드
 * 생성자 : x,y좌표를 0으로 초기화
 * 생성자오버로딩 : 밖에서 알려준 좌표로 x y 좌표를 초기화
 */

class Point2D{
	int x;
	int y;
	
	Point2D(){
		//어차피 0으로 초기화되므로 굳이 안써도됨
//		x=0;
//		y=0;
	}
	Point2D(int a, int b){
		x=a;
		y=b;
	}
	void print() {//내정보를 출력하는거
		//내가 아는걸 얘기하는거니까 매개변수가 필요X
		System.out.println("x, y는 "+x+", "+y);	
	}
	/* 기능 : 지정된 좌표로 멤버변수 x y를 이동시키는 메소드
	 * 매개변수 : 지정된 좌표
	 * 리턴타입 : 
	 * 메소드명 : move
	 * 
	 * */
	void move(int x1, int y1) {
		x = x1; y=y1;
	}
}
