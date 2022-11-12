package Chude_3;

import java.util.ArrayList;

public class CauHoiTN extends CauHoi {
	
	private ArrayList<DapAnTN> dsDapAn = new ArrayList<DapAnTN>();

    public CauHoiTN() {
    }

    public CauHoiTN(int sttCauHoi, String noiDungCauHoi, int doKho) {
        super(sttCauHoi, noiDungCauHoi, doKho);
    }

    public void themDapAn(DapAnTN dapAnTN) {
        this.dsDapAn.add(dapAnTN);
    }

    public void xoaDapAn(int index) {
        this.dsDapAn.remove(index);
    }

    public ArrayList<DapAnTN> getDsDapAn() {
        return dsDapAn;
    }

    public void setDsDapAn(ArrayList<DapAnTN> dsDapAn) {
        this.dsDapAn = dsDapAn;
    }

    public String layTT() {
        String string = new String();
        string += super.layTT() + "\n";
        for (DapAnTN dapAnTN : this.dsDapAn) {
            string += dapAnTN.layTT() + "\n";
        }
        return string;
    }
}
