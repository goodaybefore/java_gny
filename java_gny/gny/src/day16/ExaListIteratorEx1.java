package day16;
import java.util.*;
//★★★★★iterator 사용법
public class ExaListIteratorEx1 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1); list.add(2); list.add(3); list.add(4);
		
		/* 리스트는 get(번지)가 있기 때문에 for문이나 while문을 이용하여 값들을 확인할 수 있다.
		 * set은 get(번지)가 없기 때문에 for문이나 while문을 이용할 수 업고,
		 * iterator를 이용해야한다.*/
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get((int)i)+(i==list.size()-1?"\n" : ", "));
		}
		
		
		//iterator사용법
		Iterator<Integer> it = list.iterator();
		int count=0;
		//hasNext() : 다음 객체가 있으면 ture, 없으면 false를 반환
		while(it.hasNext()) {
			//next() : 다음 객체를 가져온 후 옆으로 이동
			Integer tmp = it.next();
			System.out.print(tmp + (count==list.size()-1?"\n" : ", "));
			count++;
			
		}
		

	}

}
