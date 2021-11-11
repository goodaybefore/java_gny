package day12;
//Exa : 같은 예제는 Exa Exb...로 묶어서 코드볼때 편하게 할것

public class ExaShape {
	/* 도형 클래스 : 그림판에서 그려지는 모든 도형을 대표할 수 있는 클래스
	 * day10의 Rect1, Rect2, Ellipse 클래스를 참고
	 * ex.사각형, 삼각형, 별, 선... 
	 * 
	 * 강사님) 
	 * 1 도형은 사각형 안에 그릴 수 있고, 그 사각형은 왼쪽 위의 점과 오른쪽 아래 점으로 표현할 수 있다.
	 * 2 도형은 위치를 이동시킬 수 있다.(크기는 변하지 않음)
	 * 3 도형은 크기를 변화시킬 수 있다.(방향은 마음대로)
	 * 4 도형은 방향에 상관없이 그릴 수 있다.*/
	
	//왼위, 오아 점 만들기
	//Point클래스 없이
	protected int left, top;
	protected int right, bottom;
	
	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public int getBottom() {
		return bottom;
	}

	public void setBottom(int bottom) {
		this.bottom = bottom;
	}

	//기본생성자는 안만들거임 => 4 도형은 방향에 상관없이 그릴 수 있기 때문
	//도형을 그릴 때 대각선점 2개 필요
	public ExaShape(int x1, int y1, int x2, int y2) {
		//내가한거(틀림)
		//left = x1; top = y1; right = x2; bottom = y2;
		
		//강사님
		left	= x1<x2?x1:x2;//x1과 x2 중 좀 더 작은걸 left에 삽입
		right	= x1>x2?x1:x2;//x1과 x2중 더 큰걸 right에 삽입
		top		= y1<y2?y1:y2;//이하
		bottom	= y1>y2?y1:y2;//같음
		
	}
	
	//도형의 너비를 계산하는 기능(void로도 가능?)
	public int getWidth(int left, int right) {
		int width = right-left;
//		System.out.println("r "+right);
//		System.out.println("l "+left);
		return width;
	}
	
	//도형의 높이를 계산하는 기능
	public int getHeight(int top, int bottom) {
		int height = bottom - top;
//		System.out.println("b "+bottom);
//		System.out.println("t "+top);
		return height;
	}
	
	
	//2 도형은 위치를 이동시킬 수 있다(왼쪽 위의 점)
	//수정해야함
	public void move(int left, int top) {
		this.right = left + getWidth(this.left,right);
		this.bottom = top + getHeight(this.top, bottom);
		//left를 나중에 바꿔줌 : left,top을 이동시키기 전에 right, bottom을 먼저 바꿔줌
		this.left = left;
		this.top = top;
		
		
	}
	
	//3 도형은 크기를 바꿀 수 있다 (방향은 마음대로)
	//width, height 다음 고정점 + 방향 정보 넣어주기
	//dirention의 1 2 3 4 숫자로 방향 표현하기
	/* 강사님)
	 * direction = 1인 경우 : 우하(rb)쪽으로 확장
	 * 			   2인 경우 : 좌하(lb)방향으로 확장
	 * 			   3인 경우 : 좌상(lt)방향으로 확장
	 * 			   4인 경우 : 우상(rt)방향으로 확장
	 * 										=> switch문 사용
	 * */
	public void resize(int width, int height, int direction) {
		if(width<=0 || height<=0) {
			System.out.println("잘못된 너비 또는 높이 입니다.");
			//void일때 강제종료 하고싶으면 return ;  붙여주기
			//switch문을 실행시키지 않기위해 return ; 해줌
			return ;
		}
		switch(direction) {
		//case 1 => rb가 바뀜
		case 1:
			right = left + width;
			bottom = top + height;
			break;
		case 2:
			left = right - width;//right가 숫자가 더 크니까 - 해주눈거임
			bottom = top + height;
			break;
		case 3: 
			left = right - width;
			top = bottom - height;
			break;
		case 4 :
			right = left + width;
			top = bottom - height;
			break;
		default:
			System.out.println("1~4까지의 숫자 중 하나를 입력하세요.");
			
		}
	}
	
	public void print() {
		System.out.println("====도형====");
		System.out.println("좌상점 : "+left+", "+top);
		System.out.println("우하점 : "+right+", "+bottom);
	}
	
}

//내가한거(망함)
////Point 클래스 : 두 점을 찍음
//class Point{
//	//x,y좌표
//	private int x, y;
//	//기본 객체 생성
//	public Point(){}
//	public Point(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//	
//	public Point(Point pt) {
//		this.x = pt.x;
//		this.y = pt.y;
//	}
//	public int getX() {
//		return x;
//	}
//	public void setX(int x) {
//		this.x = x;
//	}
//	public int getY() {
//		return y;
//	}
//	public void setY(int y) {
//		this.y = y;
//	}
//	
//	
//}
////사각형 클래스 : Point를 상속받음
//class Rect extends Point{
//	//왼쪽위, 오른쪽 아래 점 두개 찍기
//	private Point lt, rb;
//	public Rect() {
//	}
//	public Point getLt() {
//		return lt;
//	}
//	public void setLt(Point lt) {
//		this.lt = lt;
//	}
//	public Point getRb() {
//		return rb;
//	}
//	public void setRb(Point rb) {
//		this.rb = rb;
//	}
//	
//	//두 점을 찍어서 사각형 만들기
//	public Rect(Point lt, Point rb) {
//		this.lt = new Point(lt);
//		this.rb = new Point(rb);
//	}
//	
//	
//	
//}
//
//class Ellipse extends Point{
//	
//}