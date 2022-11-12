package tutorial.javabasic;

public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Khai báo một biến, có kiểu int (Số tự nguyên 32 bit).
        int firstNumber;
 
        // Gán giá trị cho firstNumber
        firstNumber = 10;
 
        System.out.println("First Number =" + firstNumber);
 
        // Khai báo một biến kiểu float (Số thực 32 bit)
        // Số này được gán giá trị 10.2
        // Ký tự 'f' ở cuối giúp java hiểu đây là kiểu float.
        float secondNumber = 10.2f;
 
        System.out.println("Second Number =" + secondNumber);
 
        // Khai báo một số kiểu double (Số thực 64 bit)
        // Số này được gán giá trị 10.2
        // Ký tự 'd' ở cuối giúp java hiểu đây là kiểu double.
        // Phân biệt với kiểu float 'f'.
        double thirdNumber = 10.2d;
 
        System.out.println("Third Number =" + thirdNumber);
 
        // Khai báo một biến kiểu ký tự.
        char ch = 'a';
 
        System.out.println("Char ch= " + ch);
 
    }
}
