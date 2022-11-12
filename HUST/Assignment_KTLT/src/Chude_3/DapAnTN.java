package Chude_3;

public class DapAnTN {
	
	private char tenDapAn;
    private String noiDungDapAn;
    private boolean dapAnDung;

    public DapAnTN() {
    }

    public DapAnTN(String noiDungDapAn, boolean dapAnDung) {
        this.noiDungDapAn = noiDungDapAn;
        this.dapAnDung = dapAnDung;
    }

    public DapAnTN(char tenDapAn, String noiDungDapAn, boolean dapAnDung) {
        this.tenDapAn = tenDapAn;
        this.noiDungDapAn = noiDungDapAn;
        this.dapAnDung = dapAnDung;
    }

    public char getTenDapAn() {
        return tenDapAn;
    }

    public void setTenDapAn(char tenDapAn) {
        this.tenDapAn = tenDapAn;
    }

    public String getNoiDungDapAn() {
        return noiDungDapAn;
    }

    public void setNoiDungDapAn(String noiDungDapAn) {
        this.noiDungDapAn = noiDungDapAn;
    }

    public boolean isDapAnDung() {
        return dapAnDung;
    }

    public void setDapAnDung(boolean dapAnDung) {
        this.dapAnDung = dapAnDung;
    }

    public String layTT() {
        return this.tenDapAn + ". " + this.noiDungDapAn;
    }

    public void in() {
        System.out.println(this.layTT());
    }
}
