package tutorial.javabasic.interface_and_abstractclass;

public class InstanceofDemo1 {

	public static void main(String[] args) {
		
		System.out.println("Drink "+Animal.COCACOLA);
		
		canEat x1 = new Cat("Tom");
		canEat x2 = new Mouse("Jerry");
		
		x1.Eat();
		x2.Eat();
		
		boolean isCat = x1 instanceof Cat;
		System.out.println("x1 is Cat: "+isCat);
		
		if(x2 instanceof Mouse) {
			Mouse mouse = (Mouse) x2;
			mouse.drink();
		}
	}
}
