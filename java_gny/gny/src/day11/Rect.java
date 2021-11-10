package day11;

public class Rect {
	/*좌표평면의 점을 나타내는 point클래스로 나타내봄*/
	private Point lt;	//left top(왼쪽 위 점)
	private Point rb;	//right bottom(오른쪽 아래 점)
	

	
	public Point getLt() {
		return lt;
	}

	public void setLt(Point lt) {
		this.lt = lt;
	}

	public Point getRb() {
		return rb;
	}

	public void setRb(Point rb) {
		this.rb = rb;
	}
	
	
	
	//애네를 복사생성자로 복사할것
//	public Rect(Point lt, Point rb) {//이미 생성된 객체가 들어오는 경우
//		this.lt = lt;
//		this.rb = rb;
//	}

	//"복사생성자"
	//새로운객체에 복사해서 보내줌
	public Rect(Point lt, Point rb) {
		this.lt = new Point(lt);
		//이게먼데..
		//this.lt = new Point();
//		this.lt.setX(lt.getX());
//		this.lt.setY(lt.getY());
		this.rb = new Point(rb);
		//
	}
	
	public Rect() {//기본 생성자에서 객체생성해줘야함
//		lt.print();//객체생성안해서 동작안함.에러뜸
		//멤버변수중참조변수는 객체를 만들어줘야함
		lt = new Point(0,0);
		rb = new Point(0,0);
	}
	
	public void move(int x, int y) {//우하점이 안움직이는데여ㅠㅠㅠㅠㅠㅠㅠ
		
		//rb는 width와 height만큼 더해줘야함
		/* 사각형 클래스는 Point클래스가 아니라서 Point의 점에 직접적인 접근이안됨.
		 * 그래서 getter를 통해 접근.
		*/
		int width= rb.getX()-lt.getX();
		int height = rb.getY()-lt.getY();
		System.out.println(lt.getX());
		rb.move(x+width, y+height);
		
		//lt를 옮겨줘야함. rb를 수정시켜야하므로 lt를 rb보다 늦게 옮겨주기.
		lt.move(x, y);
		
	}
	
	public void resize(int width, int height) {
		//rb건드리는거
		rb.move(lt.getX()+width, lt.getY()+height);
		
	}
	
	public void print() {
		System.out.println("===사각형===");
		System.out.print("좌상점 : ");
		lt.print();
		System.out.print("우하점 : ");
		rb.print();
	}

}
