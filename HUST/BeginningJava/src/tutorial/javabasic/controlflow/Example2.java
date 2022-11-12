package tutorial.javabasic.controlflow;

public class Example2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Khai báo một số kiểu int (Số nguyên 32 bit)
        // Đại diện cho điểm thi (score) của bạn
        int score = 20;
 
        System.out.println("Your score =" + score);
 
        // Nếu điểm số nhỏ hơn 50
        if (score < 50) {
            System.out.println("You are not pass");
        }
        // Ngược lại nếu score lớn hơn hoặc bằng 50 và nhỏ hơn 80.
        else if (score >= 50 && score < 80) {
            System.out.println("You are pass");
        }
        // Trường hợp còn lại (Nghĩa là lớn hơn hoặc bằng 80)
        else {
            System.out.println("You are pass, good student!");
        }
	}

}
