package homework1;

public class ExaRect extends ExaShape {
/* 도형 클래스를 상속받아 사각형 클래스를 만드세요
 * */
	//left, top, right, bottom 네 변수가 있음. ExaShape를 이용해 lt와 rb 얻기
	//두 점을 이용해서 width, height를 구하기

//	public ExaRect() {
//		super(); //<-부모클래스에 기본생성자가 없어서이렇게하면 에러남
//	}
	
	public ExaRect(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}
	
	
	@Override
	public void print() {
		System.out.println("====사각형====");
//		System.out.println("좌상점 : "+getLeft()+", "+getTop());
//		System.out.println("우하점 : "+getRight()+", "+getBottom());
		System.out.println("좌상점 : "+left+", "+top);
		System.out.println("우하점 : "+right+", "+bottom);
		System.out.println("가로 : "+getWidth(left,right));
		System.out.println("세로 : "+getHeight(top,bottom));
	}
	public void testR(){
		System.out.println("사각형");
	}
	
	
}
