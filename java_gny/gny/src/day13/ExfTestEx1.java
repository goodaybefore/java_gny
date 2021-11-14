package day13;

public class ExfTestEx1 {

	public static void main(String[] args) {
		/* 타원과 사각형을 같이 배열할 수 있는 배열을 만들고
		 * 타원 1개, 사각형 2개를 만들어 저장한 후 그리는 코드를 작성*/
		
		int size = 3;
		ExfShape shape[] = new ExfShape[size];
		shape[0] = new ExfEllipse(0, 0, 10, 10);
		shape[1] = new ExfRect(0, 0, 10, 10);
		shape[2] = new ExfRect(10, 10, 20, 20);
		
		for(ExfShape tmp : shape) {
			tmp.draw();
		}
		
		
	}

}


