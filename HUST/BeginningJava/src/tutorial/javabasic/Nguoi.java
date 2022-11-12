package tutorial.javabasic;

public class Nguoi {
	public String name;
	public int age;
	public String gender;
	
	public Nguoi (String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public void Hienthi() {
		System.out.println("Ten: " +name+ "; Age = " +age+ "; Gender: "+gender);
	}
}