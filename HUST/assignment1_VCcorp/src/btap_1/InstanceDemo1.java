package btap_1;

import java.util.SortedSet;
import java.util.TreeSet;

public class InstanceDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			SortedSet<Integer> newSet1 = new TreeSet<Integer>();
			
			newSet1.add(34);
			newSet1.add(657);
			newSet1.add(53);
			newSet1.add(-123);
			newSet1.add(-65);
			
			SortedSet<Integer> giaoSet = new TreeSet<>(newSet1);
			SortedSet<Integer> hopSet = new TreeSet<>(newSet1);
			
			System.out.println(giaoSet);
			System.out.println(hopSet);
			
			SortedSet<Integer> newSet2 = new TreeSet<Integer>();
			
			newSet2.add(34);
			newSet2.add(54);
			newSet2.add(523);
			newSet2.add(-123);
			newSet2.add(86);
			
			giaoSet.retainAll(newSet2);
			hopSet.addAll(newSet2);
			
			System.out.println(giaoSet);
			System.out.println(hopSet);
			
		} catch(Exception e) {
			System.out.println("Co loi");
		}
	}

}
