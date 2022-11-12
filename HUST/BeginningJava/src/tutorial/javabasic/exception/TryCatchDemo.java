package tutorial.javabasic.exception;

public class TryCatchDemo {
	public static void main(String[] args) {
		
		System.out.println("Start Recruiting ...");
		        // Kiểm tra tuổi.
		        System.out.println("Check your Age");
		        int age = 50;
		 
		        try {
		 
		            AgeUntils.checkAge(age);
		 
		            System.out.println("You pass!");
		 
		        } catch (TooYoungException e) {
		 
		            // Làm gì đó tại đây ..
		            System.out.println("You are too young, not pass!");
		            System.out.println(e.getMessage());
		 
		        } catch (TooOldException e) {
		            // Làm gì đó tại đây
		            System.out.println("You are too old, not pass!");
		            System.out.println(e.getMessage());
		 
		        }
	}
}
