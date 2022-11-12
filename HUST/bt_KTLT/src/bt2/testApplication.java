package bt2;

public class testApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Nhanvien pe1 = new Nhanvien("Vu Thi Huong Giang",5.1);
		pe1.tangHesoluong(1.0);
		pe1.setLuongcoban(10000000);
		System.out.println("Luong cua " +pe1.getName()+ " la " +pe1.tinhLuong());
		
		Nhanvien pe2 = new Nhanvien();
		pe2.name = "Vo Dinh Hung";
		pe2.hesoluong = 10;
		pe2.setLuongcoban(5000000);
		pe2.tangHesoluong(23);
		System.out.println("Luong cua " +pe2.name+ " la " +pe2.tinhLuong());
		pe2.inTTin();
	}
}
