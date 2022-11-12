package bt2;

public class TruongPhong extends Nhanvien {
	
	private double phuCap;
	private int soNamDuongChuc;
	
	public TruongPhong() {
		phuCap = 0;
		soNamDuongChuc = 1;
	}
	
	public TruongPhong(String name, double hesoluong, double phuCap, int soNamDuongChuc) {
		super(name, hesoluong);
		this.phuCap = phuCap;
		this.soNamDuongChuc = soNamDuongChuc;
	}
	
	public void setPhuCap(double phuCap) {
		this.phuCap = phuCap;
	}
	
	public double getPhuCap() {
		return phuCap;
	}
	
	public int getSoNamDuongChuc() {
		return soNamDuongChuc;
	}
}
