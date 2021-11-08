package day9;

public class MethodParameterEx1 {

	public static void main(String[] args) {
		/*ㅁ매개변수가 가변인자인 경우*/
		System.out.println(sum());
		System.out.println(sum(1));
		System.out.println(sum(1,2));
		System.out.println(sum(1,2,3));
		System.out.println(sum(1,2,3,4));
		
		
//		System.out.println(sum2());//배열이 매개변수여야해서 에러가 남
		int arr[] = new int[] {1};
		System.out.println(sum2(arr));
		System.out.println(sum2(new int[] {1}));
		System.out.println(sum2(new int[] {1,2}));
		System.out.println(sum2(new int[] {1,2,3}));
		System.out.println(sum2(new int[] {1,2,3,4}));
		
		printInfo(1,1,1,"홍길동", "홍길똥","활빈당","영웅");
		

	}
	/*기능 : 정수가 주어지면 정수의 합을 알려주는 메소드
	 * 매개변수 : 정수(여러개) => int ... nums
	 * 이때 가변인자 nums 는 배열
	 * 
	 * 리턴타입 : int
	 * 메소드명 : sum
	 * 
	 */
	public static int sum(int ... nums) {
		int sum = 0;
		for(int i=0;i<nums.length;i++) {
			sum += nums[i];
		}
		return sum;
	}
	public static int sum2(int[] nums) {
		int sum = 0;
		for(int i=0;i<nums.length;i++) {
			sum += nums[i];
		}
		return sum;
	}
	
	
	
	/* 기능 : 학생 학년 반 번호 이름 별명들이 주어지면 학생 정보를 콘손에 출력하는 메소드
	 * 매개변수 : 학년 반 번호 이름 별명(0~여러개)
	 * 리턴타입 : void
	 * 메소드명 : printInfo 
	 */
	public static void printInfo(int grade, int classNum, int num, String name, String ... nickname) {
		System.out.println("학년 : "+grade);
		System.out.println("반 : "+classNum);
		System.out.println("번호 : "+num);
		System.out.println("이름 : "+name);
		for(int i=0;i<nickname.length;i++) {
			System.out.print(nickname[i]+" ");
		}
		System.out.println();
		
	}
	

}
