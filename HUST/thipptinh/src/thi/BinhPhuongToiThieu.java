/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi;

import thi.Array;  
import thi.MathFormulas;
import java.lang.Object;

public class BinhPhuongToiThieu {
    
    private String parenthesization(double a) {
        if (a >= 0) {
            return String.valueOf(a);
        } else {
            return "(" + String.valueOf(a) + ")";
        }
    }

    /**
     * noi suy da thuc tuyen tinh bac n
     * @param x bang gia tri x
     * @param y bang gia tri y
     * @param n bang cua da thuc
     */
    public double[] tuyenTinh(double[] x, double[] y, int n) {
        HePhuongTrinh giaiPhuongTrinh = new HePhuongTrinh();
        MathFormulas calculator = new MathFormulas();
        Array arrTools = new Array();
        double[][] tong = new double[3 * n + 1][x.length];
        double[] temp = new double[2 * n + 1];
        double[][] leftHand = new double[n+1][n+1];
        double[] rightHand = new double[n+1];
        for (int i = 0; i < 2 * n; i++) { //bang gia tri x
            for (int j = 0; j < tong[0].length; j++) {
                tong[i][j] = calculator.exponential(i + 1, x[j]);
            }
        }
        for (int i = 2 * n; i < tong.length; i++) { //bang gia tri x*y
            for (int j = 0; j < tong[0].length; j++) {
                tong[i][j] = y[j] * calculator.exponential(i - 2 * n, x[j]);
            }
        }
        temp[0] = x.length;
        for (int i = 1; i < temp.length; i++) {
            temp[i] = arrTools.sum(tong[i - 1]);
        }
        for (int i = 0; i < leftHand.length; i++) {
            for (int j = 0; j < leftHand[0].length; j++) {
                leftHand[i][j] = temp[i + j];
            }
        }
        for (int i = 0; i < rightHand.length; i++) {
            for (int j = 0; j < tong[0].length; j++) {
                rightHand[i] += tong[i+temp.length-1][j];
            }
        }
        double[] result = giaiPhuongTrinh.equatSolvers(leftHand, rightHand);
        System.out.print("y = ");
        for (int i = result.length-1; i > 0; i--) {
            System.out.print(parenthesization(result[i])+"*x^"+i+" + ");
        }
        System.out.println(parenthesization(result[0]));
        return result;
    }
    
    /**
     * noi suy ham y = a*e^(bx)
     * @param x
     * @param y 
     */
    public void eMu(double[] x, double[] y) {
        Math calculator = null;
        Array arrTool = new Array();
        double a, b;
        double[] Y = new double[y.length];
        for (int i = 0; i < Y.length; i++) {
            Y[i] = calculator.log10(y[i]);
        }
        double[] result = tuyenTinh(x, Y, 1);
        a = calculator.pow(10, result[0]);
        b = result[1]/calculator.log10(calculator.E);
        System.out.println(calculator.E);
        System.out.println("y = " + a+"*e^("+b+"x)");
    }
    
    /**
     * noi suy ham y = a*x^b
     * @param x
     * @param y 
     */
    public void loga(double [] x, double[] y){
        Math calculator = null;
        Array arrTool = new Array();
        double a, b;
        double[] Y = new double[y.length], X = new double[x.length];
        for (int i = 0; i < Y.length; i++) {
            Y[i] = calculator.log10(y[i]);
            X[i] = calculator.log10(x[i]);        
        }
        double[] result = tuyenTinh(X, Y, 1);
        a = calculator.pow(10, result[0]);
        System.out.println("y = "+ a+"x^"+result[1]);
    }

    public static void main(String[] args) {
        BinhPhuongToiThieu a = new BinhPhuongToiThieu();
        double[] x = new double[8], y = new double[8];
        x[0] = 10.0;
        x[1] = 20.0;
        x[2] = 30.0;
        x[3] = 40.0;
        x[4] = 50.0;
        x[5] = 60.0;
        x[6] = 70.0;
        x[7] = 80.0;
        y[0] = 1.06;
        y[1] = 1.33;
        y[2] = 1.43;
        y[3] = 1.68;
        y[4] = 1.81;
        y[5] = 1.91;
        y[6] = 2.01;
        y[7] = 2.11;
        a.loga(x, y);
    }
}
