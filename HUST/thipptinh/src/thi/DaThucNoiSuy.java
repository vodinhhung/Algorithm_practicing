/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  thi;

public class DaThucNoiSuy {

    private String parenthesization(double a) {
        if (a >= 0) {
            return String.valueOf(a);
        } else {
            return "(" + String.valueOf(a) + ")";
        }
    }

    private void tien(double[] x, double[] y, double[][] tiHieu) {
        for (int i = 0; i < tiHieu.length; i++) {
            tiHieu[0][i] = (y[i + 1] - y[i]) / (x[i + 1] - x[i]);
        }
        for (int i = 1; i < tiHieu.length; i++) {
            for (int j = 0; j < tiHieu.length - i; j++) {
                tiHieu[i][j] = (tiHieu[i - 1][j + 1] - tiHieu[i - 1][j]) / (x[i + j + 1] - x[j]);
            }
        }
    }

    private void lui(double[] x, double[] y, double[][] tiHieu) {
        for (int i = tiHieu.length - 1; i >= 0; i--) {
            tiHieu[0][i] = (y[i + 1] - y[i]) / (x[i + 1] - x[i]);
        }
        for (int i = 1; i < tiHieu.length; i++) {
            for (int j = tiHieu.length - i - 1; j >= 0; j--) {
                tiHieu[i][j] = (tiHieu[i - 1][j + 1] - tiHieu[i - 1][j]) / (x[i + j + 1] - x[j]);
            }
        }
    }

    /**
     * Hien thi da thuc noi suy tien
     *
     * @param x
     * @param y
     */
    private void newtonTien(double[] x, double[] y, double[][] tiHieu) {
        System.out.println("Da thuc noi suy tien: ");
        System.out.print("P(x) = " + parenthesization(y[0]) + " + ");
        System.out.print(parenthesization(tiHieu[0][0]) + "*(x - " + parenthesization(x[0]) + ") + ");
        for (int i = 1; i < tiHieu.length; i++) {
            System.out.print(parenthesization(tiHieu[i][0]) + "*(x - " + parenthesization(x[0]) + ")*(x - ");
            for (int j = 1; j < i; j++) {
                System.out.print(parenthesization(x[j]) + ")*(x - ");
            }
            if (i != tiHieu.length - 1) {
                System.out.print(parenthesization(x[i]) + ") + ");
            } else {
                System.out.print(parenthesization(x[i]) + ").");
            }
        }
    }

    /**
     * Hien thi da thuc noi suy lui
     *
     * @param x
     * @param y
     */
    private void newtonLui(double[] x, double[] y, double[][] tiHieu) {
        System.out.println("Da thuc noi suy lui: ");
        System.out.print("P(x) = " + parenthesization(y[y.length - 1]) + " + ");
        System.out.print(parenthesization(tiHieu[0][tiHieu.length - 1]) + "*(x - " + parenthesization(x[tiHieu.length]) + ") + ");
        for (int i = 1; i < tiHieu.length; i++) {
            System.out.print(parenthesization(tiHieu[i][tiHieu.length - i - 1]) + "*(x - " + parenthesization(x[tiHieu.length]) + ")*(x - ");
            for (int j = tiHieu.length - 1; j > tiHieu.length - i; j--) {
                System.out.print(parenthesization(x[j]) + ")*(x - ");
            }
            if (i != tiHieu.length - 1) {
                System.out.print(parenthesization(x[tiHieu.length - i]) + ") + ");
            } else {
                System.out.print(parenthesization(x[tiHieu.length - i]) + ").");
            }
        }
    }

    /**
     * Tinh da thuc noi suy tai diem z.
     * A(n) = 2(n-1)! voi phep nhan la phep tinh chu yeu
     * Do cong thuc noi suy newton tien va lui su dung theo hai canh cua tam giac trong bang sai phan, khi can tinh gia tri
     * y tai diem z gan x[0], ta su dung cong thuc tien. Con khi z gan x[n-1], ta su dung cong thuc lui.
     * Do dac diem tren nen khi can tinh x o gan gia tri trung binh cua x[0] va x[n-1], ta su dung cong thuc tien hoac lui deu
     * duoc, nhung bat loi do 1 loat cac gia tri sai phan cac cap bi bo qua. Vi vay, trong truong hop nay nen su dung cong thuc 
     * noi suy Larange.
     * Neu can tim gia tri gan dung y tai diem z khong thuoc khoang (x[0], x[n-1]), ta co:
     *  - Neu z nho hon x[0], ta su dung cong thuc tien
     *  - Neu z lon hon x[0], ta su dung cong thuc lui. 
     * Day la gia tri ngoai suy
     * @param x
     * @param y
     */
    public double newton(double[] x, double[] y, double z) {
        Array a = new Array();
        double[][] tiHieu = new double[x.length - 1][x.length - 1];
        if (z >= (x[y.length - 1]) - x[0]||x[0]>z) {
            tien(x, y, tiHieu);
            newtonTien(x, y, tiHieu);
            System.out.println("");
            System.out.print("Result = ");
            double result = y[0] + tiHieu[0][0] * (z - x[0]);
            for (int i = 1; i < tiHieu.length; i++) {
                double temp = tiHieu[i][0] * (z - (x[0]));
                for (int j = 1; j <= i; j++) {
                    temp = temp * (z - x[j]);
                }
                result += temp;
            }
            return result;
        } else {
            lui(x, y, tiHieu);
            newtonLui(x, y, tiHieu);
            System.out.println("");
            System.out.print("Result = ");
            double result = y[y.length - 1] + tiHieu[0][tiHieu.length - 1] * (z - (x[tiHieu.length]));
            for (int i = 1; i < tiHieu.length; i++) {
                double temp = tiHieu[i][tiHieu.length - i - 1] * (z - x[tiHieu.length]);
                for (int j = tiHieu.length - 1; j >= tiHieu.length - i; j--) {
                    temp *= (z - x[j]);
                }
                result += temp;
            }
            return result;
        }
    }
    
    /**
     * Tinh da thuc noi suy tai diem x.
     * A(n) = 4(n-1)*n voi phep nhan la phep tinh chu yeu
     * Nen chon lagrand voi ham chay nhanh hon, lap trinh de hon, va ngan hon.
     * @param x
     * @param y
     * @param z
     * @return 
     */
    public double lagrange(double[] x, double[] y, double z){
        Array arrTool = new Array();
        double[] daThucCS = new double[x.length];
        arrTool.generate1(daThucCS);
        for (int i = 0; i < daThucCS.length; i++) {
            for(int j = 0; j<daThucCS.length;j++){
                if(j!=i){
                    daThucCS[i] *= (x[i]-x[j]);
                }
            }
        }
        arrTool.Display(daThucCS);
        System.out.println("Da thuc noi suy: ");
        System.out.print("P(x) = ");
        for (int i = 0; i < daThucCS.length; i++) {
            System.out.print(parenthesization(y[i]));
            for (int j = 0; j < daThucCS.length-1; j++) {
                if(j!=i){
                System.out.print("*(x - " + parenthesization(x[j])+")");
                }
            }
            if(i!=daThucCS.length-1){
                System.out.print("*(x - "+parenthesization(x[daThucCS.length-1])+")/"+parenthesization(daThucCS[i])+" + ");
            }
            else{
                System.out.println("/"+parenthesization(daThucCS[i])+".");
            }
        }
        double result = 0;
        for (int i = 0; i < daThucCS.length; i++) {
            double temp = y[i]/daThucCS[i];
            for (int j = 0; j < daThucCS.length; j++) {
                if(j!=i){
                    temp*=(z-x[j]);
                }
            }
            result+=temp;
        }
        return result;
    }

    public static void main(String[] args) {
        DaThucNoiSuy a = new DaThucNoiSuy();
        double[] x = new double[4], y = new double[4];
        x[0] = -1;
        x[1] = 0;
        x[2] = 3;
        x[3] = 6;
        y[0] = -3;
        y[1] = -6;
        y[2] = 39;
        y[3] = 822;
        System.out.println(a.newton(x, y, 5.5));
        System.out.println(a.lagrange(x, y, 5.5));
    }
}
