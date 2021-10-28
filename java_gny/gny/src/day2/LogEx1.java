package day2;

public class LogEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//AND연산자 예제. A학점 판별을 이용
		int score=85;
		
		//100점 이하이고 score가 90 이상이다
		//100보다 작거나 같고, 90점부다 크거나같다
		boolean isA = score<=100 && score>=90;
		System.out.println(isA);
		
		boolean DLicense=true, regCard = false;
		boolean testOK=DLicense||regCard;
		System.out.println("응시가능?" + testOK);
		
		//not 연산자
		boolean isMale=true;
		System.out.println("남자임?" +isMale);
		System.out.println("여자임?" +!isMale);
		
		

	}

}
