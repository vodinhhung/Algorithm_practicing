package bt2;

public class Nhanvien {
	public double hesoluong,luong,tangHesoluong,luongCoban;
	public String name;
	
	private static final double LUONG_MAX = 2000000000;
	
	public Nhanvien() {
		name = "NONAME";
		hesoluong = 1;
	}
	
	public String getName() {
		return name;
	}
	public void setLuongcoban(double luongCoban) {
		this.luongCoban = luongCoban;
	}
	
	public Nhanvien(String name, double hesoluong) {
		this.name = name;
		this.hesoluong = hesoluong;
	}
	
	public void inTTin() {
		System.out.println("Ten: "+name+ "; Luong = "+luong);
	}
	
	public boolean tangHesoluong(double tangHesoluong) {
		if((hesoluong+tangHesoluong)*luongCoban < LUONG_MAX) {
			hesoluong+=tangHesoluong;
			return true;
		}
		else {
			return false;
		}
	}
	
	public double tinhLuong() {
		luong = hesoluong*luongCoban;
		return luong;
	}
	
	public double getLuong() {
		return luong;
	}
}
