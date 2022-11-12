package tutorial.javabasic.interface_and_abstractclass;

public class Cat extends Animal implements canEat, canDrink {
	
	private String name;
	
	public Cat(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getVelocity() {
		return 110;
	}
	
	public void drink() {
		System.out.println(name+ " can drink " );
	}
	
	public void Eat() {
		System.out.println(name+ " can eat coconut");
	}
}
