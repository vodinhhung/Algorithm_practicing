package Chude_3;

public class CauHoiTL extends CauHoi {
	
	 private String dapAnTL;

	    public CauHoiTL() {
	    }

	    public CauHoiTL(int sttCauHoi, String noiDungCauHoi, int doKho) {
	        super(sttCauHoi, noiDungCauHoi, doKho);
	    }

	    public String getDapAnTL() {
	        return dapAnTL;
	    }

	    public void setDapAnTL(String dapAnTL) {
	        this.dapAnTL = dapAnTL;
	    }

	    public String layTT() {
	        return super.layTT();
	    }

	    public void in() {
	        System.out.println(this.layTT());
	    }
}
