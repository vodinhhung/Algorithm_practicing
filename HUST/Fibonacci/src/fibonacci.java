import java.util.Scanner;
public class fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Chuong trinh in day Fibonacci voi n so hang
		// khai bao bien
		Scanner sc = new Scanner(System.in);
		int n;
		int a=0,b=1,c=1;
		
		// Nhap vao so hang n
		System.out.println("Nhap vao so n");
		n = sc.nextInt();
		
		// In day Fibonacci
		System.out.format("Day Fibonacci voi %d phan tu la:",n);
		System.out.format("%d\n %d\n %d\n",a,b,c);
		for(int i=1; i <= (n-3); i++) {
			a=b; b=c;
			c= a+b;
			System.out.format("%d\n",c);
		}
		sc.close();
	}

}
