package day18;
import java.util.*;
//익명클래스
//1회용 클래스
//어렵다....... 근데 알아둬야함.....정렬같은게 꼭필요
public class ExeAnoymousEx1 {
	
	public static void main(String[] args) {
		//주어진 리스트를 오름차순, 내림차순 해보기
		List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(15);
		list.add(11);
		list.add(1);
		
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);//오름차순
		
		/* 아래의 sort는 정수형 리스트와 Comparator 인터페이스를 구현한 구현클래스의 객체가 필요
		 * 구현클래스 객체리스트 하나정돈 괜찮은데 여러개 사용하면 불편해짐
		 * 이 때 필요한게 익명클래스
		 * 
		 * 클래스를 그자리에서 바로 new 연산자를 사용해 만들어서 만들어진 객체를 이용해서 사용*/
		
		//근데 compare코드가 이해가 안됨...하ㅠ
		Collections.sort(list, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		System.out.println(list);
		
		
		
		List<String> strList = new ArrayList<String>();
		strList.add("an");
		strList.add("apple");
		strList.add("orange");
		strList.add("banana");
		Collections.sort(strList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2); 
				//return -o1.compareTo(o2); //사전 역순으로 정렬하고 싶을 때
			}
		});
		System.out.println(strList);
		
		
		
		

	}

}
