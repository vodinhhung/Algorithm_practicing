package tutorial.javabasic.interface_and_abstractclass;

public class Mouse extends Animal implements canDrink, canEat {
	
	private String name;
	
	public Mouse(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void Eat() {
		System.out.println(name+ " can eat ...");
	}
	
	public void drink() {
		System.out.println(name+ " can drink ...");
	}
	
	public int getVelocity() {
		return 85;
	}
	
}
