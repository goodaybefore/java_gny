package day11;
//정사각형클래스 - 직사각형 클래스를 상속받음
public class Square extends Rect {
	int side;//정사각형읜 가로세로 길이가 똑같음
	public Square() {
		/* lt는 부모의 멤버변수이지만 private으로 되어있어서
		 * 물려받긴 했지만 직접 사용할 수는 없다.
		 * 따라서 public으로 된 setter를 이용하여 lt에 접근해야한다. 
		 * */
		
//		lt = new Point(0,0); //파란색이면 멤버변수. 부모클래스에서 변수가 private으로 선언되어있으면 사용할수없음.
		Point tmp = new Point();
		setLt(tmp);
	}
	
	public Square(Point pt, int side) {
		//pt를 lt에 저장해야함
		//side를 멤버변수 side에 저장해야함
		
		//lt = pt; //부모에게 물려받긴 했지만 접근권한이 없음. 그래서setLt한테 요청해야함
		//setLt(pt); // lt와 밖에서 알려준 pt를 공유함
		Point tmp = new Point(pt);//복사생성자로 복사
		setLt(tmp);//=setLt(new Point(pt));
		this.side = side;
	}
	
	//resize는 메소드 오버로딩. 왜? Rect의 resize는 매개변수가 2개(width, height)필요함
	public void resize(int side) {
		this.side = side;
		
	}
	
	
	//Rect에서 물려받은 print() 메소드를 재정의
	@Override//요거추가했을때 빨간줄안나면 제대로 오버라이딩 한거 맞음
	public void print() {
		System.out.println("===정사각형===");
		//
		System.out.println("시작점 : ");
		//lt.print(); //lt에 접근 권한이 없어서 에러가 남
		getLt().print();//get은 매개변수가필요없어!
		System.out.println("정사각형의 한 변의 길의는 "+side);
	}
}
