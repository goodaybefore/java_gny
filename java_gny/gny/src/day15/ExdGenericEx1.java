package day15;

public class ExdGenericEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExdData<Integer> data1 = new ExdData<Integer>(10);
		ExdData<Double> data2 = new ExdData<Double>(10.0);
		ExdData<Double> data3 = new ExdData<Double>(10.0);
		data1.print();
		data2.print();
		
//		if(data1==data2)//에러발생
		if(data3 == data2) {
			System.out.println("비교가능하고 같은 객체");
		}else {
			System.out.println("비교 가능하고 다른 객체");
		}
		
//		ExdData<String> data4;에러발생 : String은 Number의 자손이 아니므로
		
		
		
		//와일드카드 예제
		data2.test(data3);
		data2.test(data1);
	}

}
