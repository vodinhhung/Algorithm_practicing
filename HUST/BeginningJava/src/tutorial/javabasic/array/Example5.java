package tutorial.javabasic.array;

public class Example5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] myArray = new int[5];
		myArray[0] = 10;
		myArray[1] = 20;
		myArray[2] = 30;
		myArray[3] = 40;
		myArray[4] = 50;
		
		//In ra man hinh
		
		System.out.println("Array Length = " + myArray.length);
		System.out.println("myArray[3] = " +myArray[3]);
		
		//In tat ca mang ra man hinh
		
		for(int i=0; i< myArray.length; i++) {
			System.out.println("Element" + i + "=" + myArray[i]);
		}
		
	}

}
