package day15;

import java.util.ArrayList;
import java.util.List;
//List의 get set remove contains indexOf
public class ExeListEx1 {

	public static void main(String[] args) {
		//정수를 저장하는 List를 만드는 예제
		
		
		
		List<Integer> list1 = new ArrayList<Integer>();
		list1.size();//=.length랑 같음. 들어갈 수 있는 크기X 들어가있는 크기를 의미
		int arr1[] = new int[5];
		arr1[0] = 1;
		list1.add(1);
		arr1[1] = 2;
		list1.add(2);
		
		System.out.println(arr1[0]);
		//get메소드는 List에만 있고, Set에는 없음!
		//set은 순서를 보장하지 않기 때문에 get의 의미가 없음.
		System.out.println(list1.get(0));
		
		System.out.println("배열의 크기 : "+arr1.length);
		System.out.println("리스트에 저장된 갯수: "+list1.size());
		
		System.out.println(list1);
		//remove(Object obj) : obj와 일치하는 객체를 제거한 후 제거한 객체를 알려줌
		//remove(int index) : index번지에 있는 객체를 제거한 후 제거한 객체를 알려줌
//		list1.remove(1);//얘는 int index가 지워진것 ㅜ.. 1번지의 객체를 제거함. int 사용할때는 조심해야함
		list1.remove((Integer)1);//1과 일치하는 객체를 제거
		System.out.println(list1);
		
		
		list1.add(5);
		list1.add(4);
		list1.add(10);
		System.out.println(list1);
		//contains	: 리스트에 객체와 일치하는 객체의 존재여부를 알려줌
		//indexOf	: 리스트에 객체와 일치하는 객체가 있으면 1, 없으면 -1을 알려주는 기능
		System.out.println("1이 리스트에 있는지 "+list1.contains(1));
		System.out.println("5가 리스트에 있는지 "+list1.contains(5));
		System.out.println("1이 리스트에 있는지 "+list1.indexOf(1));
		System.out.println("5가 리스트에 있는지 "+list1.indexOf(5));
	}

}
