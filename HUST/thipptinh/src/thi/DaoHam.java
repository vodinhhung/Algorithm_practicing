/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi;

import thi.Array;   
import thi.MathFormulas;
import thi.Polynomial;

public class DaoHam {

    /**
     * tinh dao ham tai cac moc noi suy cach deu
     *
     * @param x bang x. x.length = 2, 3 ,4 
     * @param y bang y
     * @param z gia tri dao ham
     * @param n =1 neu la da thuc, -1 neu la phan thuc
     * @param denominator mau so neu n =-1, da thuc neu n= 1
     * @param numerator tu so neu n = -1, null neu n = -1
     * @param deriDenominator dao ham cua da thuc
     * @return
     */
    public double daoHamBang(double[] x, double[] y, double z, int n, double[] denominator, double[] numerator, double[] deriDenominator) {
        if (x.length == 2) {
            double h = (x[1] - x[0]);
            double err = 0, max = Double.MIN_VALUE;
            for (double i = x[0]; i <= x[1]; i+=0.01) {
                double temp = derivativeXTH(n, denominator, i, 2, deriDenominator, numerator);
                if (temp > max) {
                    max = temp;
                }
            }
            err = max * h / 2;
            if (z == x[0]) {
                return (y[1] - y[0]) / h - err;
            } else {
                return (y[1] - y[0]) / h + err;
            }
        }
        else {if (x.length == 3) {
            double h = (x[2] - x[0]) / 2;
            double err, max = Double.MIN_VALUE;
            for (double i = x[0]; i <= x[2]; i+=0.01) {
                double temp = derivativeXTH(n, denominator, i, 3, deriDenominator, numerator);
                if(temp>max){
                    max = temp;
                }
            }
            if (z == x[0]) {
                err = max*h*h/3;
                return (((-3*y[0]+4*y[1]-y[2])/2*h)+err);
            }
            else{
                if(z ==x[1]){
                    err = max*h*h/6;
                    return (-y[0]+y[2])/(2*h)+err;
                }
                else{
                    err = max*h*h/3;
                    return (y[0]+4*y[1]+3*y[2])/(2*h) +err;
                }
            }
        }
        else{
            double h = (x[3] - x[0]) / 3; 
            double err, max = Double.MIN_VALUE;
            for (double i = x[0]; i <= x[3]; i+=0.01) {
                double temp = derivativeXTH(n, denominator, i, 4, deriDenominator, numerator);
                if(temp>max){
                    max = temp;
                }
            }
            if(z==x[0]){
                err = max*h*h*h/4;
                return (-11*y[0]+18*y[1]-9*y[2]+2*y[3])/(6*h) +err;
            }
            else{
                if(z==x[1]){
                    err = max*h*h*h/8;
                    return (-2*y[0]-3*y[1]+6*y[2]-y[3])/(6*h) +err;
                }
                else{
                    if(z==x[2]){
                    err = max*h*h*h/8;
                    return (y[0]-6*y[1]+3*y[2]+2*y[3])/(6*h) +err;
                }
                    else{
                        err = max*h*h*h/6;
                    return (-2*y[0]+9*y[1]-18*y[2]+11*y[3])/(6*h) +err;
                    }
                }
            }
        }
    }
    }

    /**
     * derivative at z, not use for logarithm and exponential
     *
     * @param n if n =1, the function is differentiated as a polynomial . Else,
     * n = -1, it will formed as 1/(polynomial). Therefore, differentiate the
     * polynomial, multiply it with (-1) and divide polynomial^2
     * @param coef coefficient of polynomial
     * @param deriCoef coefficient of polynomial after differentiating.
     * deriCoef.length = coef.length -1
     * @param z X0
     * @return derivative of function at z
     */
    public double derivative1ST(int n, double[] coef, double z, double[] deriCoef) {
        MathFormulas calculator = new MathFormulas();
        if (n >= 0) {
            double result = 0;
            for (int i = 0; i < deriCoef.length; i++) {
                deriCoef[i] = coef[i + 1] * (i + 1);
                result += deriCoef[i] * calculator.exponential(i, z);
            }
            return result;
        } else {
            double result = 0;
            for (int i = 0; i < deriCoef.length; i++) {
                deriCoef[i] = coef[i + 1] * (i + 1);
                result += deriCoef[i] * calculator.exponential(i, z);
            }
            result *= n;
            double temp = 0;
            for (int i = 0; i < coef.length; i++) {
                temp += coef[i] * calculator.exponential(i, z);
            }
            temp = calculator.exponential(2, temp);
            result /= temp;
            return result;
        }
    }

    /**
     *
     * @param n if n =1, the function is differentiated 2 times as a polynomial
     * . Else, n = -1, it will formed as 1/(polynomial). Therefore,
     * differentiate the polynomial, multiply it with (-1) and divide
     * polynomial^(2*x)
     * @param coef coefficient of polynomial
     * @param z X0
     * @param x is times of derivation. x is larger than and equal to 2
     * @param deriCoef coefficient of polynomial after differentiating.
     * deriCoef.length = coef.length -1
     * @param numerator has value when the function which is going to be
     * differentiated is not polynomial
     * @return
     */
    public double derivativeXTH(int n, double[] coef, double z, int x, double[] deriCoef, double[] numerator) {
        MathFormulas calculator = new MathFormulas();
        Polynomial polyTool = new Polynomial();
        Array arrTools = new Array();
        if (n >= 0) {
            if (x > 1) {
                derivative1ST(n, coef, z, deriCoef);
                if (deriCoef.length == 1) {
                    return 0;
                } else {
                    double[] tempCoef = new double[deriCoef.length - 1];
                    return derivativeXTH(n, deriCoef, z, x - 1, tempCoef, numerator);
                }
            } else {
                double result = 0;
                for (int i = 0; i < deriCoef.length; i++) {
                    deriCoef[i] = coef[i + 1] * (i + 1);
                    result += deriCoef[i] * calculator.exponential(i, z);
                }
                return result;
            }
        } else {
            if (x >= 1) {
                derivative1ST(1, coef, z, deriCoef); //coef: coefficient of denominator; deriCoef is derivative of coefficient
                double[] denominator = polyTool.polyMult2(coef, coef);
                double[] deriNumerator = new double[numerator.length - 1]; //derivative of numerator
                double[] tempNumerator;
                if (numerator.length > 1) {
                    derivative1ST(1, numerator, z, deriNumerator);
                    tempNumerator = arrTools.subtract(polyTool.polyMult2(coef, deriNumerator), polyTool.polyMult2(deriCoef, numerator));
                    double[] tempDeriCoef = new double[denominator.length - 1];
                    return derivativeXTH(n, denominator, z, x - 1, tempDeriCoef, tempNumerator);
                } else {
                    tempNumerator = deriCoef;
                    return derivativeXTH(n, denominator, z, x - 1, deriCoef, tempNumerator) * (-1);
                }
            } else {
                double result = 0, tempNumerator = 0, tempDenomnator = 0;
                for (int i = 0; i < coef.length; i++) {
                    tempDenomnator += coef[i] * calculator.exponential(i, z);
                }
                for (int i = 0; i < numerator.length; i++) {
                    tempNumerator += numerator[i] * calculator.exponential(i, z);
                }
                result = tempNumerator / tempDenomnator;
                return result;
            }
        }
    }

    public static void main(String[] args) {
        DaoHam a = new DaoHam();
        double[] b = new double[3];
        b[0] = 1;
        b[1] = 2;
        b[2] = 1;
        double[] c = new double[1];
        c[0] = 1;
        double[] d = new double[2];
        System.out.println(a.derivativeXTH(-1, b, 1, 4, d, c));
    }
}
