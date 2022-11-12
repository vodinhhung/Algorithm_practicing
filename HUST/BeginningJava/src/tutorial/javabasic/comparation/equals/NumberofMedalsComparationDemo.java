package tutorial.javabasic.comparation.equals;

public class NumberofMedalsComparationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		NumberOfMedals american = new NumberOfMedals(40,25,4);
		
		NumberOfMedals japan = new NumberOfMedals(30,33,12);
		
		NumberOfMedals korea = new NumberOfMedals(30,33,11);
		
		NumberOfMedals vietnam = new NumberOfMedals(30,33,12);
		
		System.out.println("Medals of America equals Japan "+american.equals(japan));
		
		System.out.println("Medals of Japan equals Viet Nam "+japan.equals(vietnam));
		
		System.out.println("Medals of Korea equals Viet Nam "+korea.equals(vietnam));
	}

}
