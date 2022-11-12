package tutorial.javabasic.ArrayList;

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

public class ListandListIterator {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("One");
		list.add("Two");
		list.add("Three");
		list.add("Four");
		
		ListIterator<String> listiterator = list.listIterator();
		
		String first = listiterator.next();
		System.out.println("First: "+first);
		
		String second = listiterator.next();
		System.out.println("Second: "+second);
		
		if(listiterator.hasPrevious()) {
			String value1 = listiterator.previous();
			System.out.println("value1: "+value1);
		}
		
		while(listiterator.hasNext()) {
			String value2 = listiterator.next();
			System.out.println("value2: "+value2);
		}
	}
}