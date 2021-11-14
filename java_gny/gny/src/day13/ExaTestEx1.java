package day13;

public class ExaTestEx1 {
	public static void main(String[] args) {
		
		/* 도형을 그리는 기능을 shape에 추상 메소드로 만든 경우와, 그리는 기능을 Shape에서 제외한 클래스의 차이를 보여주는 예제
		 * 부모에 그리는 기능이 있으면, 다형성을 이용하여 조건없이(형변환 확인없이) 그리는 기능을 사용할 숭 ㅣㅆ지만,
		 * 부모에 그리는 기능이 없으면 형변환 가능한지 확인하고, 형변환한 후 그릴 수 있다.
		 * */
		//A예제
		
		//다형성으로 클래스 형변환
		ExaShape shapeList1[] = new ExaShape[3];
		shapeList1[0] = new ExaEllipse();
		shapeList1[1] = new ExaRect();
		shapeList1[2] = new ExaRect();
		
		for(ExaShape tmp : shapeList1) {
			if(tmp != null) {
				tmp.print();
			}
		}
		System.out.println("===================");
		
		
		
		
		//B예제
		ExbShape shapeList2[] = new ExbShape[3];
		shapeList2[0] = new ExbEllipse();
		shapeList2[1] = new ExbRect();
		shapeList2[2] = new ExbRect();
		
		for(ExbShape tmp : shapeList2) {
			if(tmp instanceof ExbRect) {
//				tmp.print();//부모에 print 기능이 없어서 따로 형변환 후 기능을 이용해야함
				((ExbRect)tmp).print();
			}else if(tmp instanceof ExbRect) {
				((ExbEllipse)tmp).print();
			}
		}
		
	}
}
