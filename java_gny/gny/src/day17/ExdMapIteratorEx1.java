package day17;
import java.util.*;
public class ExdMapIteratorEx1 {
	//강사님피셜 어려움!!
	public static void main(String[] args) {
		/* Map에서 반복문 사용하기
		 * map에서 키값 중복안됨. 그래서 이 키값으로 set을 만들 수 있음
		 * 
		 * keySet()을 이용하여 키값들을 set으로 만든 후 Iterator를 이용하는 방법*/
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("abc123", "123123");
		map.put("qweqwe", "qweqwe");
		map.put("zzz", "zzzzzzz");
		
		//반복문으로 출력하기 ; Iterator활용
		Set<String> set = map.keySet();
		/* keySet() : map에서 key값들을 하나의 set으로 만들어주는 메소드
		 * 가능한이유 = > key는 중복이 안된다!(set의 특성과 일치)*/
		System.out.println(set);
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key);
		}
		
		
	}

}
