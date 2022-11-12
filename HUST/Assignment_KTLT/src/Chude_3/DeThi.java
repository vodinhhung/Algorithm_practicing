package Chude_3;

import java.util.ArrayList;

public class DeThi {
	
	private String tenDeThi;
    private ArrayList<CauHoi> dsCauHoi = new ArrayList<CauHoi>();

    public DeThi() {
    }

    public DeThi(String tenDeThi) {
        this.tenDeThi = tenDeThi;
    }

    public void themCauHoi(CauHoi cauHoi) {
        this.dsCauHoi.add(cauHoi);
    }

    public void xoaCauHoi(int index) {
        this.dsCauHoi.remove(index);
    }

    public String getTenDeThi() {
        return tenDeThi;
    }

    public void setTenDeThi(String tenDeThi) {
        this.tenDeThi = tenDeThi;
    }

    public ArrayList<CauHoi> getDsCauHoi() {
        return dsCauHoi;
    }

    public void setDsCauHoi(ArrayList<CauHoi> dsCauHoi) {
        this.dsCauHoi = dsCauHoi;
    }

    public String layTT() {
        String string = new String();
        string += this.tenDeThi + "\n";
        for (CauHoi cauHoi : this.dsCauHoi) {
            string += "\n" + cauHoi.layTT();
        }
        return string;
    }

    public void in() {
        System.out.println(this.layTT());
    }
}
