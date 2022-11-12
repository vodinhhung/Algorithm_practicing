package Chude_3;

import java.util.ArrayList;

public class MonHoc {
	
	private String tenMonHoc;
    ArrayList<CauHoi> dsCauHoi = new ArrayList<CauHoi>();
    ArrayList<DeThi> dsDeThi = new ArrayList<DeThi>();

    public MonHoc() {
    }

    public MonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public boolean taoDeThi(String tenDeThi, int soCauTN, int soCauTL, int doKho) {
        ArrayList<CauHoiTN> dsCauHoiTN = new ArrayList<CauHoiTN>();
        ArrayList<CauHoiTL> dsCauHoiTL = new ArrayList<CauHoiTL>();
        for (CauHoi cauHoi : this.dsCauHoi) {
            if (cauHoi instanceof CauHoiTN) {
                dsCauHoiTN.add((CauHoiTN) cauHoi);
            } else if (cauHoi instanceof CauHoiTL) {
                dsCauHoiTL.add((CauHoiTL) cauHoi);
            }
        }
        if (soCauTN > dsCauHoiTN.size() || soCauTL > dsCauHoiTL.size()) {
            return false;
        } else {
        	return true;
        }
    }

    public void themCauHoi(CauHoi cauHoi) {
        this.dsCauHoi.add(cauHoi);
    }

    public void xoaCauHoi(int index) {
        this.dsCauHoi.remove(index);
    }

    public void themDeThi(DeThi deThi) {
        this.dsDeThi.add(deThi);
    }

    public void xoaDeThi(int index) {
        this.dsDeThi.remove(index);
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public ArrayList<CauHoi> getDsCauHoi() {
        return dsCauHoi;
    }

    public ArrayList<DeThi> getDsDeThi() {
        return dsDeThi;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public void setDsCauHoi(ArrayList<CauHoi> dsCauHoi) {
        this.dsCauHoi = dsCauHoi;
    }

    public void setDsDeThi(ArrayList<DeThi> dsDeThi) {
        this.dsDeThi = dsDeThi;
    }
}
