package tutorial.javabasic.inheritance;

public class Cats extends Animal {
	
	private int age;
	private int height;
	
	public Cats(int age, int height) {
		super();
		this.age = age;
		this.height = height;
	}
	
	public Cats(String name, int age, int height) {
		super(name);
		this.age = age;
		this.height = height;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public String getAnimalname() {
		return "Cats";
	}
}
