package btap_1;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Random;

public class InstanceDemo {

	public static void main(String[] args) {
		
		try {
			Random rand = new Random();
		
			SortedSet<Integer> newSet1 = new TreeSet<Integer>();
			
			while (newSet1.size() < 2000) {
				newSet1.add(rand.nextInt());
			}
			
			SortedSet<Integer> giaoSet = new TreeSet<>(newSet1);
			SortedSet<Integer> hopSet = new TreeSet<>(newSet1);
			
			SortedSet<Integer> newSet2 = new TreeSet<Integer>();
			
			while (newSet2.size() < 2000){
				newSet2.add(rand.nextInt());
			}
			
			long millis1 = System.currentTimeMillis();
			
			giaoSet.retainAll(newSet2);
			hopSet.addAll(newSet2);
			
			long millis2 = System.currentTimeMillis();
			long distance = millis2 - millis1;
			
			System.out.println(giaoSet);
			System.out.println(hopSet);
			System.out.println("Kich thuoc tap giao: "+giaoSet.size());
			System.out.println("kich thuoc tap hop: "+hopSet.size());
			System.out.println("thoi gian thuc hien: "+distance);
			
		} catch(Exception e) {
			System.out.println("Co loi");
		}
	}
}
