package tutorial.javabasic;

class Nhanvien extends Nguoi {
	
	private float luong;
	
	public Nhanvien(String name, int age, String gender, float luong) {
		super(name, age, gender);
		this.luong = luong;
	}
	
	public static void main(String[] args) {
		Nhanvien hung = new Nhanvien("Hung", 20, "nam", 3000);
		hung.Hienthi();
		System.out.println("Luong: " +hung.luong);
		
		Nhanvien anh = new Nhanvien("Anh", 22, "nu", 4000);
		anh.Hienthi();
		System.out.println("Luong cua " +anh.name+ " la " +anh.luong+ "$/month");
	}
}
