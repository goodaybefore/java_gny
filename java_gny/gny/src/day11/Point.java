package day11;
//2차원 좌표평면의 점 하나를 나타내는 클래스
public class Point {
	int x,y;
	public Point(){}
	
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

	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//매개변수에 본인 클래스가 오는 경우
	//멤버변수를 복사하는 "복사생성자"
	public Point(Point pt) {
		this.x = pt.x;
		this.y = pt.y;
	}
	//좌표 이동 기능
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//좌표 출력 기능
	public void print() {
		System.out.println("("+x+", "+y+")");
	}

}
