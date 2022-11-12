package tutorial.javabasic.ArrayList;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SortedSet<player> players = new TreeSet<player>();
		
		player tom = new player("Tom",1,3,5);
		player jerry = new player("Jerry",0,5,4);
		player mickey = new player("Mickey",0,9,8);
		
		players.add(tom);
		players.add(jerry);
		players.add(mickey);
		
		for (player player: players) {
			System.out.println("Player: "+player);
		}
	}
}
