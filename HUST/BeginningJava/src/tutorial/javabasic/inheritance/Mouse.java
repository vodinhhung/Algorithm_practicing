package tutorial.javabasic.inheritance;

public class Mouse extends Animal {
	
	private int weight;

	public Mouse(String name, int weight) {
		super(name);
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public String getAnimalname() {
		return "Mouse";
	}
}
