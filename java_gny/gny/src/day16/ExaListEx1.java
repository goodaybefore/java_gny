package day16;

import java.util.*;

public class ExaListEx1 {

	public static void main(String[] args) {
		/* list1은 ArrayList를 이용한 리스트이기 때문에 생성자가 반드시 ArrayList여야함
		 * lset2는 List를 이용한 리스트이기 때문에 생성자가 List인터페이스를 구현한 구현 클래스 아무거나 올 수 있다.*/
		//둘다 리스트인데 만든 클래스가 다름. but 혼합해서 사용은 가능
		//링크드리스트랑 어레이리스트랑 기능이 똑같음. 데이터의 관리하는 방법에 관해서의 차이가 있음.
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		//list2에는 링크드리스트랑 어레이리스트 둘다 올 수 있음
		List<Integer> list2 = new LinkedList<Integer>();
		
		list1.add(1); list1.add(2); list1.add(3); list1.add(4);
		list2.add(11); list2.add(12); list2.add(13); list2.add(4);
		
		System.out.println("list1 : "+list1);
		System.out.println("list2 : "+list2);
		
		
		//false 나옴. 전체가 포함이 아니라 부분이 포함되어있어서
		System.out.println("list1에 list2가 포함되어 있는지 "+list1.containsAll(list2));
		
		System.out.println("===========addAll동작 후===========");
		list1.addAll(list2);
		System.out.println("list1 : "+list1);
		System.out.println("list2 : "+list2);
		System.out.println("list1에 list2가 포함되어 있는지 "+list1.containsAll(list2));
		
		//list1에 중복으로 들어가있던 4 두개가 다 삭제됨
		System.out.println("===========removeAll동작 후===========");
		list1.removeAll(list2);
		System.out.println("list1 : "+list1);
		System.out.println("list2 : "+list2);
		
		
		System.out.println("===========clear 동작 후===========");
		list1.clear();
		System.out.println("list1 : "+list1);
		
//		list1.//햇을때 옆에 뜨는겆숭에 ArrayList : 에레이리스트에서 그대로 가져온거/List : List에서 받아온것
		System.out.println("======list1에 1이랑 1 추가한 후 set(1,2)하면");
		list1.add(1); list1.add(1);
		System.out.println(list1.set(1, 2));
		System.out.println("list1 : "+list1);
		
	}

}
