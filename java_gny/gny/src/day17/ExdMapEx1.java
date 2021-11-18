package day17;
import java.util.*;
public class ExdMapEx1 {
	//제네릭클래스 Map 사용
	public static void main(String[] args) {
		/* */
		
		//id : 앞의 String , pw : 뒤의 String
		Map<String, String> userInfo = new HashMap<>();
		//비번은 중복되어도 회원 정보가 추가됨
		userInfo.put("abc123", "123123");
		userInfo.put("qwe123", "123123");
		//아이디는 중복되면 회원정보가 수정됨
		userInfo.put("qwe123", "1231234");
		System.out.println(userInfo);
		
		//put, remove, get
		//remove : key값으로 검색
		userInfo.remove("abc123");
		System.out.println(userInfo);
		//get : key값으로 검색해서 비번 알려줌
		System.out.println(userInfo.get("qwe123"));
		//"qwe123"이 존재하는지 안하는지 반환
		System.out.println(userInfo.containsKey("qwe123"));

	}

}
