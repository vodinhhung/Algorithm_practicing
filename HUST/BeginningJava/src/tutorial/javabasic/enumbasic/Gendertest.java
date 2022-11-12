package tutorial.javabasic.enumbasic;

public class Gendertest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Gender marryGender = Gender.FEMALE;
	
		System.out.println("Code: " +marryGender.getCode());
		System.out.println("Text: " +marryGender.getText());
	
		for(Gender x : Gender.values()) {
			System.out.println(x.getCode());
		}
		
		String code = "M";
		Gender g = Gender.getGenderbycode(code);
		
		System.out.println("Gender by code: "+Gender.getGenderbycode(code));
	}
}