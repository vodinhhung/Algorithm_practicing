package tutorial.javabasic.exception;

public class AgeUntils {
	public static void checkAge(int age) throws TooYoungException, TooOldException {
		if(age < 18)
			throw new TooYoungException("Age " +age+ " too young.");
		else if (age > 40)
			throw new TooOldException("Age " +age+ " too old");
		else System.out.println("Age "+age+ " OK");
	}
}
