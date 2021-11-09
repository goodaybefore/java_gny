package day10;

public class Rect1 {
	private int x,y,width,height;
	Rect1(){
		
	}
	Rect1(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	 
	public void print() {
		System.out.println("좌표평면 ("+x+","+y+")로부터 가로 "+width+", 세로 "+height);
	}
	//시작점 이동 기능
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//사각형 크기 변경 기능
	public void resize(int width, int height) {
		this.width = width;
		this.height = height;
		
	}
	
}
