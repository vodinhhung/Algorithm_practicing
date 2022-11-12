package tutorial.javabasic.comparation.equals;

public class Actor implements Comparable<Actor> {
	
	private String lastName;
	private String firstName;
	
	public Actor (String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int compareTo(Actor other) {
		int value = this.lastName.compareTo(other.lastName);
		
		if(value != 0)
			return value;
		value = this.firstName.compareTo(other.firstName);
		return value;
	}
}
