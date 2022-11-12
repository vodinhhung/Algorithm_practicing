package thi;

import thi.Array;
import thi.MathFormulas;
import thi.Polynomial;

public class TichPhan {

    /**
     * Cong thuc hinh thang, tinh tich phan tren doan [a,b], ta thay neu lay
     * nhieu moc noi suy hon thi se dat sai so cap cao hon, nhung cong thuc se
     * tro nen phuc tap
     *
     * @param a can duoi
     * @param b can tren
     * @return
     */
    public double antiDerivative(double a, double b, int n, double[] denominator, double[] deriCoef, double[] numerator, double err) {
        DaoHam daoHam = new DaoHam();
        MathFormulas calculator = new MathFormulas();
        Polynomial poly = new Polynomial();
        Array arrTool = new Array();
        double[] tempDenominator = new double[denominator.length];
        arrTool.copy(denominator, tempDenominator);
        double[] tempNumerator = new double[numerator.length];
        arrTool.copy(numerator, tempNumerator);
        double max = Double.MIN_VALUE;
        for (double i = a; i <= b; i += 0.01) {
            double temp = daoHam.derivativeXTH(n, denominator, i, 2, deriCoef, numerator);
            if (calculator.abs(temp) > max) {
                max = calculator.abs(temp);
            }
        }
        int m = (int) calculator.nthRoot(((max) * calculator.exponential(3, (b - a)) / (12 * err)), 2) + 1;
        double h = (b - a) / m;
        double[] x = new double[m + 1], y = new double[m + 1];
        for (int i = 0; i < m + 1; i++) {
            x[i] = a + h * i;
            if (n == -1) {
                y[i] = poly.functionCalcu(x[i], tempNumerator, tempDenominator);
            } else {
                y[i] = poly.polynomialCaculating(x[i], tempDenominator);
            }
        }
        double temp = 0;
        for (int i = 2; i < y.length; i++) {
            temp += y[i];
        }
        double result = h * (y[0] + y[1] + 2 * temp) / 2;
        System.out.println("Tich phan: " + result + ".Error: " + err);
        return result;
    }

    /**
     * Cong thuc sim son, tinh tich phan tren doan [a,b], ta thay neu lay nhieu
     * moc noi suy hon thi se dat sai so cap cao hon, nhung cong thuc se tro nen
     * phuc tap
     *
     * @param a can duoi
     * @param b can tren
     * @param n
     * @param denominator
     * @param deriCoef
     * @param numerator
     * @param err
     * @return
     */
    public double antiDerivative2(double a, double b, int n, double[] denominator, double[] deriCoef, double[] numerator, double err) {
        MathFormulas calculator = new MathFormulas();
        DaoHam daoHam = new DaoHam();
        Polynomial poly = new Polynomial();
        double max = Double.MIN_VALUE;
        Array arrTool = new Array();
        double[] tempDenominator = new double[denominator.length];
        arrTool.copy(denominator, tempDenominator);
        double[] tempNumerator = new double[numerator.length];
        arrTool.copy(numerator, tempNumerator);
        for (double i = a; i <= b; i += err) {
            double temp = daoHam.derivativeXTH(n, denominator, i, 4, deriCoef, numerator);
            if (calculator.abs(temp) > max) {
                max = calculator.abs(temp);
            }
        }
        double temp = 16 * 180 * err / (max * calculator.exponential(5, (b - a)));
        int r = (int) (1 / (calculator.nthRoot(temp, 4))) + 1;
        double h = (b - a) / (2 * r);
        double[] x = new double[2 * r + 1], y = new double[2 * r + 1];
        for (int i = 0; i < x.length; i++) {
            x[i] = a + h * i;
            if (n == -1) {
                y[i] = poly.functionCalcu(x[i], tempNumerator, tempDenominator);
            } else {
                y[i] = poly.polynomialCaculating(x[i], tempDenominator);
            }
        }
        double oddTemp = 0, evenTemp = 0;
        for (int i = 2; i < y.length - 2; i += 2) {
            evenTemp += y[i];
        }
        for (int i = 1; i < y.length - 1; i += 2) {
            oddTemp += y[i];
        }
        double result = h * ((y[0] + y[2 * r]) + 2 * evenTemp + 4 * oddTemp) / 3;
        System.out.println("Tich phan: " + result + ".Error: " + err);
        return result;
    }

    public static void main(String[] args) {
        TichPhan a = new TichPhan();
        double[] numerator = new double[1];
        double[] denominator = new double[3], deriDenominator = new double[2];
        numerator[0] = 1;
        denominator[0] = 1;
        denominator[1] = 0;
        denominator[2] = 1;
        a.antiDerivative2(0, 1, -1, denominator, deriDenominator, numerator, 0.0002);
    }

}
