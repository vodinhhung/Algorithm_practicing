package tutorial.javabasic.interface_and_abstractclass;

public abstract class Animal implements canDrink, canEat, canMove {
	public void run() {
		System.out.println("Animal runs ...");
	}
	
	public void hide() {
		System.out.println("Animal can hide ...");
	}
}
