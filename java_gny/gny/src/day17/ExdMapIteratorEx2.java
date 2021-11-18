package day17;

import java.util.*;
import java.util.Map.Entry;

//어려움! 중요22
//첫번째방법이 더 편하긴함
public class ExdMapIteratorEx2 {
	
	public static void main(String[] args) {
		/* Map에서 반복문을 사용하는 예제 = 교재 p414
		 * Entry클래스를 이용하여 반복문을 활용하는 방법
		 * Entry 클래스는 제네릭클래스로 두개의 값이 필요함.
		 * Entry<A,B> : 멤버변수에서, A는 Key, B는 value
		 * */
		Map<String, String> map = new HashMap<String, String>();
		map.put("abc123", "123123");
		map.put("qweqwe", "qweqwe");
		map.put("zzz", "zzzzzzz");
		
		/* EntrySet() : key와 value를 멤벼변수로 갖는 Entry클래스가 있고,
		 * 각 key와 value들을 Entry 클래스의 객체로 바꾼 후 set에 담아서 알려주는 메소드 
		 * Q. 그럼 get set을 못쓰겠네요?
		 * */
		
		//Entry 클래스로 된 Set만들기
		Set<Map.Entry<String, String>> set = map.entrySet();//내부클래스
		//Iterator 만들기
		Iterator<Map.Entry<String, String>> it = set.iterator();
		while(it.hasNext()) {
			Map.Entry<String, String> e =it.next();
			String key = e.getKey();
			String value = e.getValue();
			System.out.println("ID : "+key+", PW : "+value);
		}
		
	}

}
