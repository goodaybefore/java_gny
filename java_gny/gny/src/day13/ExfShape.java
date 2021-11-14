package day13;

public abstract class ExfShape implements ExfDraw {
	protected int left, top, right, bottom;
	@Override
	public void resize(int width, int height) {
		right = left + width; bottom = top + height;
	}

	@Override
	public void move(int x, int y) {
		int width = right-left, height = bottom-top;
		left = x; top = y;
		right = x + width; bottom = y + height;
	}

	//draw 안쓸거임 자식들이 할거임 => abstract 붙여줘야함
	//draw가 있긴한데 구현하지 않은 것 뿐임!
//	@Override
//	public void draw() {
//	}
	
	
	public ExfShape(int x1, int y1, int x2, int y2) {
		left = x1>x2?x2:x1;
		right= x1<x2?x2:x1;
		top =  y1>y2?y2:y1;
		top =  y1<y2?y2:y1;
	}

}
