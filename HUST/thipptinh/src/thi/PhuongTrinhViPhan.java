/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi;

import thi.Array;

public class PhuongTrinhViPhan {

    double phuongTrinh1, phuongTrinh2;

    double getPT1() {
        return phuongTrinh1;
    }

    double getPT2() {
        return phuongTrinh2;
    }

    /**
     * Truoc khi su dung cong thuc tinh nghiem ham vi phan, can nhap bieu thuc
     * vi phan tai result
     *
     * @param x
     * @param y
     * @return
     */
    public double PhuongTrinhViPhan(double x, double y) {
        double result = x + y;
        return result;
    }

    /**
     * Truoc khi su dung cong thuc tinh nghiem ham vi phan, can nhap bieu thuc
     * vi phan tai result
     *
     * @param x
     * @param y
     * @return
     */
    public void PhuongTrinhViPhan(double x, double y, double z) {
        this.phuongTrinh1 = z;
        this.phuongTrinh2 = -(x * z) - y;
    }

    /**
     * cong thuc euler cai tien co uu diem la tinh toan thuan loi. de lap trinh,
     * nhuoc diem la sai so lon (h^3). Vi vay, cong thuc chi thich hop voi cai
     * diem gan gia tri x0. Day dong thoi la cong thuc runge-Kutta voi q = 2
     *
     * @param x0 gia tri cho san
     * @param y0 gia tri y tai x = 0
     * @param h khoang giua cac phan tu giua a va b
     * @param a dau mut
     * @param b dit mut
     */
    public void euler(double x0, double y0, double h, double a, double b) {
        Array arrTool = new Array();
        int length = (int) ((b - a) / h) + 1;
        double[] x = new double[length], y = new double[length];
        for (int i = 0; i < x.length; i++) {
            x[i] = x0 + h * i;
        }
        y[0] = y0;
        for (int i = 1; i < y.length; i++) {
            double temp = y[i - 1] + h * PhuongTrinhViPhan(x[i - 1], y[i - 1]);
            y[i] = y[i - 1] + h * (PhuongTrinhViPhan(x[i - 1], y[i - 1]) + PhuongTrinhViPhan(x[i], temp)) / 2;
        }
        System.out.println("X: ");
        arrTool.Display(x);
        System.out.println("");
        System.out.println("Y: ");
        arrTool.Display(y);
    }

    /**
     * Dat do chinh xac cao ma cong thuc tinh khong qua phuc tap
     * @param x0
     * @param y0
     * @param h
     * @param a
     * @param b
     * @param q
     */
    public void runguKutta(double x0, double y0, double h, double a, double b, double q) {
        if (q == 2) {
            euler(x0, y0, h, a, b);
        } else {
            Array arrTool = new Array();
            int length = (int) ((b - a) / h) + 1;
            double[] x = new double[length], y = new double[length];
            for (int i = 0; i < x.length; i++) {
                x[i] = x0 + h * i;
            }
            y[0] = y0;
            if (q == 3) {
                for (int i = 1; i < x.length; i++) {
                    double k1 = h * PhuongTrinhViPhan(x[i - 1], y[i - 1]);
                    double k2 = h * PhuongTrinhViPhan(x[i - 1] + h / 2, y[i - 1] + k1 / 2);
                    double k3 = h * PhuongTrinhViPhan(x[i - 1] + h, y[i - 1] - k1 + 2 * k2);
                    y[i] = y[i - 1] + (k1 + 4 * k2 + k3) / 6;
                }
            } else {
                for (int i = 1; i < x.length; i++) {
                    double k1 = h * PhuongTrinhViPhan(x[i - 1], y[i - 1]);
                    double k2 = h * PhuongTrinhViPhan(x[i - 1] + h / 2, y[i - 1] + k1 / 2);
                    double k3 = h * PhuongTrinhViPhan(x[i - 1] + h / 2, y[i - 1] + k2 / 2);
                    double k4 = h * PhuongTrinhViPhan(x[i - 1] + h, y[i - 1] + k3);
                    y[i] = y[i - 1] + (k1 + 2 * k2 + 2 * k3 + k4) / 6;
                }
                System.out.println("X: ");
                arrTool.Display(x);
                System.out.println("");
                System.out.println("Y: ");
                arrTool.Display(y);
            }
        }
    }

    /**
     * cong thuc dat sai so mot buoc la h^5
     *
     * @param x0
     * @param y0
     * @param z0
     * @param h
     * @param a
     * @param b
     */
    public void runguKutta2(double x0, double y0, double z0, double h, double a, double b) {
        Array arrTool = new Array();
        int length = (int) ((b - a) / h) + 1;
        double[] x = new double[length], y = new double[length], z = new double[length];
        for (int i = 0; i < x.length; i++) {
            x[i] = x0 + h * i;
        }
        y[0] = y0;
        z[0] = z0;
        for (int i = 1; i < x.length; i++) {
            PhuongTrinhViPhan(x[i - 1], y[i - 1], z[i - 1]);
            double k1 = h * getPT1();
            double l1 = h * getPT2();
            PhuongTrinhViPhan(x[i - 1] + h / 2, y[i - 1] + k1 / 2, z[i - 1] + l1 / 2);
            double k2 = h * getPT1();
            double l2 = h * getPT2();
            PhuongTrinhViPhan(x[i - 1] + h / 2, y[i - 1] + k2 / 2, z[i - 1] + l2 / 2);
            double k3 = h * getPT1();
            double l3 = h * getPT2();
            PhuongTrinhViPhan(x[i - 1] + h, y[i - 1] + k3, z[i - 1] + l3);
            double k4 = h * getPT1();
            double l4 = h * getPT2();
            y[i] = y[i - 1] + (k1 + 2 * k2 + 2 * k3 + k4) / 6;
            z[i] = z[i - 1] + (l1 + 2 * l2 + 2 * l3 + l4) / 6;
        }
        System.out.println("X: ");
        arrTool.Display(x);
        System.out.println("");
        System.out.println("Y: ");
        arrTool.Display(y);
        System.out.println("");
        System.out.println("Z: ");
        arrTool.Display(z);
    }

    /**
     * Sai so mot buoc la h^2.
     *
     * @param x0 gia tri cho san
     * @param y0 gia tri y tai x = 0
     * @param h khoang giua cac phan tu giua a va b
     * @param a dau mut
     * @param b dit mut
     */
    public void euler(double x0, double y0, double z0, double h, double a, double b) {
        Array arrTool = new Array();
        int length = (int) ((b - a) / h) + 1;
        double[] x = new double[length], y = new double[length], z = new double[length];
        for (int i = 0; i < x.length; i++) {
            x[i] = x0 + h * i;
        }
        y[0] = y0;
        z[0] = z0;
        for (int i = 1; i < y.length; i++) {
            PhuongTrinhViPhan(x[i - 1], y[i - 1], z[i - 1]);
            z[i] = z[i - 1] + h * getPT2();
            y[i] = y[i - 1] + h * getPT1();
        }
        System.out.println("X: ");
        arrTool.Display(x);
        System.out.println("");
        System.out.println("Y: ");
        arrTool.Display(y);
        System.out.println("Z: ");
        System.out.println("");
        arrTool.Display(z);
    }

    public static void main(String[] args) {
        PhuongTrinhViPhan a = new PhuongTrinhViPhan();
        a.runguKutta2(0, 0, 1.0, 0.1, 0, 0.5);
    }
}
