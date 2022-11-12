package tutorial.javabasic.enumbasic;

public class InstanceDemo {
	public static void main(String[] args) {
		
		Weekday[] allDays = Weekday.values();
		for(Weekday day:allDays) {
			System.out.println("Day: " +day);
		}
	}

}
