package Chude_3;

public class CauHoi {
	
	private int sttCauHoi;
    private String noiDungCauHoi;
    private int doKho;

    public CauHoi() {
    }

    public CauHoi(int sttCauHoi, String noiDungCauHoi, int doKho) {
        this.sttCauHoi = sttCauHoi;
        this.noiDungCauHoi = noiDungCauHoi;
        this.doKho = doKho;
    }

    public void setSttCauHoi(int sttCauHoi) {
        this.sttCauHoi = sttCauHoi;
    }

    public void setNoiDungCauHoi(String noiDungCauHoi) {
        this.noiDungCauHoi = noiDungCauHoi;
    }

    public void setDoKho(int doKho) {
        this.doKho = doKho;
    }

    public int getSttCauHoi() {
        return sttCauHoi;
    }

    public String getNoiDungCauHoi() {
        return noiDungCauHoi;
    }

    public int getDoKho() {
        return doKho;
    }

    public String layTT() {
        return "Câu " + this.sttCauHoi + ":" + this.noiDungCauHoi;
    }
    public void in(){
        System.out.println(this.layTT());
    }
}
