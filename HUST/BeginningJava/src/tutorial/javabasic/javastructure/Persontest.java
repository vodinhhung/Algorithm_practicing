package tutorial.javabasic.javastructure;

public class Persontest {
	public static void main(String[] args) {
	
		Person edison = new Person("Edison");
	
		String name1 = edison.name;
		System.out.println("Person 1: " + name1);
	
		Person billGate = new Person("Bill Gates");
	
		String name2 = billGate.getName();
		System.out.println("Person 2: " + name2);
	}
}
