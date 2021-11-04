package day7;

public class MethodPrimeNumEx1 {

	public static void main(String[] args) {
		/*   주어진 정수가 소수인지 아닌지 판별하는 메소드
		 * */
		int num = 4;
//		boolean prime = isPrime(num);
		if(isPrime(num)) System.out.println("소수입니다");//★★★★★★★★★★★★ 이렇게도 if문 가능;;;
		else System.out.println("소수가 아닙니다");
		
		
		if(true) System.out.println("true");
	}
	public static boolean isPrime(int a) {
		int cnt=0;
		if(a<=0) return false;//0보다 작으면 바로 false를 return
		for(int i=1;i<=a;i++) {
			if(a%i==0) cnt++;
		}
		if(cnt==2) return true;
		else return false;//else 생략해도됨
		
	}

}
