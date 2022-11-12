package tutorial.javabasic.loop;

public class Example4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Khai báo một biến 'step', mô tả bước của vòng lặp (Vòng lặp thứ mấy)
        int step = 1;
 
        // Khai báo một biến 'value' với giá trị bắt đầu là 0
        // Sau mỗi một bước lặp 'value' lại được công thêm 3
        // Và vòng lặp sẽ kết thúc khi 'value' lớn hơn hoặc bằng 10
        for (int value = 0; value < 10; value = value + 3) {
 
            System.out.println("Step =" + step + "  value = " + value);
 
            // Tăng giá trị 'step' lên 1, sau mỗi bước lặp
            step = step + 1;
 
        }
	}

}
