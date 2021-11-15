package day14;

public class ExcWrapperEx1 {

	public static void main(String[] args) {
		/* Wrapper 예제*/
		int num =10;
		Integer numi = num;
		//print에 정수를 넣었는데 동작하는 이유 : int형 num이 Integer로 오토박싱 된거임
		print(num);//print((Integer)num);
		print(numi);
		
		num = numi;//Integer 객체 numi를 넘에 오토언박싱하여 저장
		System.out.println(numi);
		numi = null;
		num=numi;//NullPointerException 예외 발생. null을 정수로 변환할 수 없다.

	}
	public static void print(Object obj) {
		System.out.println(obj.toString());
	}

}
