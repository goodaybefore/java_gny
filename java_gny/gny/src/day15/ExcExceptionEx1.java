package day15;
import java.util.*;
public class ExcExceptionEx1 {

	public static void main(String[] args) {
		/* 5개짜리 정수 배열에 5개의 숫자를 입력받아 저장한 후
		 * 원하는 번지의 정수를 수정하는 코드 작성
		 * -1입력하면 프로그램 종료
		 * 
		 * 
		 * */
		Scanner sc = new Scanner(System.in);
//		int arr[] = new int[5];
		int arr[] = null;
		int index  = 0, value = 0;
		try {
			inputArr(sc, arr);
			modifyArr(sc, arr);
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
			System.out.println("프로그램종료!!");
		}
		
		
		
		
		
		
		
		
	}
	/* 기능 : 
	 * 
	 */
	public static void inputArr(Scanner sc, int arr[]) {
		//배열이 없으면 예외발생
		//예외처리를 시키는 습관을 들이자!
		if(arr==null) throw new NullPointerException("배열이 만들어지지 않았습니다");
		if(sc ==null) throw new NullPointerException("스캐너가 만들어지지 않았습니다");
		
		System.out.println("정수를 "+arr.length+"개 입력하세요 (예 : 1 2 3 4 5 .. )");
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		
		
	}
	public static void modifyArr(Scanner sc, int arr[]) {
		int index = 0, value = 0;
		/* try catch문을 감싸는 기준
		 * do while문을 계속 돌릴거면 안에 try catch문을, 예외발생하고 반복 끝낼거면 반복문 밖에 try catch*/
		do {
			try {
				System.out.println("수정할 번지와 수정할 숫자를 입력하세요");
				index = sc.nextInt();
				value = sc.nextInt();
				//배열에 넣어줄수있는조건설정
				if(index >=0) arr[index] = value;
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("배열의 범위 내에서 선택해주세요. "+index);
//				e.printStackTrace();//스레드 이용해서 작업함. 동시에 작업을 시작할수있어서 print출력중에 printStackTrace가 같이 출력됨
			}
			
			System.out.println(Arrays.toString(arr));
			
		}while(index > 0);
	}
	
	

}
