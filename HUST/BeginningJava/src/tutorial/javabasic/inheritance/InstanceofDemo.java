package tutorial.javabasic.inheritance;

import tutorial.javabasic.inheritance.Animal;
import tutorial.javabasic.inheritance.Cats;
import tutorial.javabasic.inheritance.Mouse;

public class InstanceofDemo {
	public static void main(String[] args) {
		Animal Tom = new Cats("Tom",2,20);
		
		System.out.println("Ten con meo la "+Tom.getname());
		System.out.println("animalName: "+Tom.getAnimalname());
		
		boolean a = Tom instanceof Mouse;
		System.out.println("Tom is mouse: "+a);
		
		boolean b = Tom instanceof Cats;
		System.out.println("Tom is cat: " +b);
		
		boolean c = Tom instanceof Animal;
		System.out.println("Tom is animal: "+c);
		
	}
}
