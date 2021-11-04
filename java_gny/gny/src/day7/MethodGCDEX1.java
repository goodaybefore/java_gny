package day7;

public class MethodGCDEX1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 20;
		int b = 8;
		
		System.out.println("최대공약수는 "+GCD(a,b));
		System.out.println("최소공배수는 "+LCM(a,b));
		System.out.println("최소공배수는 "+LCM2(a,b));

	}
	public static int GCD(int a, int b) {
		
		int smallNum = a>b?b:a;
		int GCD=0;
		for(int i=1;i<smallNum;i++) {
			if(a%i==0 && b%i==0 && GCD<i) {
				GCD = i;
			}
		}
		return GCD;
	}
	public static int LCM(int a, int b) {
		int mulA;
		for(int i=1;;i++) {
			mulA = a*i;
			if(mulA%b==0) {
				break;
			}
		}return mulA;
	}
	
	//두 수의 곱 / 최대공약수 = 최소공배수
	public static int LCM2(int a, int b) {
		return a*b/GCD(a,b);
	}

}
