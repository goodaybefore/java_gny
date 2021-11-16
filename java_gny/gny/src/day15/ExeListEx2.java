package day15;

import java.util.ArrayList;

public class ExeListEx2 {

	public static void main(String[] args) {
		/* 하나의 점이 이동한 좌표를 저장하려고 한다.
		 * */
		ExePoint pt = new ExePoint(0, 0);
		ArrayList<ExePoint> moveRoute = new ArrayList<ExePoint>();
//		//처음위치 저장
//		moveRoute.add(pt);
//		//점을 이동 후 위치 저장
//		pt.move(5, 5);
//		moveRoute.add(pt);
//		pt.move(10, 10);
//		moveRoute.add(pt);
//		System.out.println(moveRoute);
//		//세가지의 pt주소가 다 같다(같은 객체이다)
//		//따라서 마지막에 바뀌면 앞에꺼가 다같이 바뀐다.
//		//그래서 class에 복사생성자 만들어줘야한다
		
		
		
		//복사생성자를 사용하여 출력하기
		moveRoute.add(new ExePoint(pt));
		pt.move(5, 5);
		moveRoute.add(new ExePoint(pt));
		pt.move(10, 10);
		moveRoute.add(new ExePoint(pt));
		System.out.println(moveRoute);
		
		
		//equals 추가 전에 : false가 나옴
		//contains indexOf는 equals로 비교하는데, Point 클래스에 equals가 없어서 == 으로 비교하는것
		System.out.println(pt+"좌표가 list에 있습니까? : "+moveRoute.contains(pt));
		System.out.println(pt+"좌표가 list에 있습니까? : "+moveRoute.indexOf(pt));//0 1 번지를 지나 2번지에 있기 때문에 2가 나와야함

		
		//toString도 오버라이딩 해주는게 조음
		 
		

	}

}
class ExePoint{
	int x;
	int y;
	public ExePoint(int x, int y){
		this.x = x; this.y = y;
	}
	
	//복사생성자
	public ExePoint(ExePoint p) {
		x = p.x; y = p.y;
	}
	public void move(int x, int y) {
		this.x = x; this.y=y;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExePoint other = (ExePoint) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	//★★★★이렇게 print하는 법도 있구나 하기
	@Override
	public String toString() {
		return ("("+x+", "+y+")");
	}
}