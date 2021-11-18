package day17;
import java.util.*;
//set은 사용을 잘 안한다구 함...
public class ExcSetBaseballEx1 {

	public static void main(String[] args) {
		/* 1~9사이의 중복X 랜덤한 수 3개를 저장해서 숫자 야구게임을 만드려고 한다
		 * 숫자 3개 만들어보세요*/
		Set<Integer> tmp = new HashSet<Integer>();
		List<Integer> com = new ArrayList<Integer>();
		int min=1, max=9;
		
		
		
		
		//깨알 상식
//		//set에서 add는 리턴이 true. 하지만 중복되면 false를 리턴 
//		System.out.println(tmp.add(1));
//		System.out.println(tmp.add(1));
		
		while(tmp.size()<3) {
			int r = (int)(Math.random()*(max-min+1)+min);
			boolean isAdd = tmp.add(r);
			//isAdd == true이면 tmp에 숫자가 추가된 경우이기 때문에 리스트에 추가
			if(isAdd == true) {
				com.add(r);
			}
		}
		System.out.println(tmp);
		System.out.println(com);
		
		
		
		
		
	}

}

