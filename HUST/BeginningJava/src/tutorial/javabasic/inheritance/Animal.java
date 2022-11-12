package tutorial.javabasic.inheritance;

public abstract class Animal {
	private String name;
	
	public Animal() {
		this.name = this.getAnimalname();
	}
	
	public Animal(String name) {
		this.name = name;
	}
	
	public String getname() {
		return name;
	}
	
	public void Setname(String name) {
		this.name = name;
	}
	
	public abstract String getAnimalname();
}
