/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi;

import thi.Array;

public class Polynomial {

    /**
     *
     */
    Array arrayTool = new Array();

    /**
     * calculating the polynomial with coefficients array[i], i = 0, 1, ... n-1 at point x
     * @param x
     * @param array
     * @return
     */
    public double polynomialCaculating(double x, double[] array) { // c
        double product = array[array.length - 1];
        for (int i = array.length - 2; i >= 0; i--) {
            product = product * x + array[i];
        }
        return product;
    }

    /**
     *
     * @param x
     * @param array
     * @return
     */
    public double functionCalcu(double x, double[] numerator, double[] denominator) { // caculating the polinomial with coefficients array[i], i = 0, 1, ... n-1 at point x
        return polynomialCaculating(x, numerator) / polynomialCaculating(x, denominator);
    }

    /**
     *
     * @param splitedArray
     * @param subArray1
     * @param subArray2
     * @param subArrayLength
     */
    private void split(double[] splitedArray, double[] subArray1, double[] subArray2, int subArrayLength) {
        for (int i = 0; i < subArrayLength; i++) {
            subArray1[i] = splitedArray[i];
        }
        for (int i = subArrayLength; i < (2 * subArrayLength - 1); i++) {
            subArray2[i - subArrayLength] = splitedArray[i];
        }
        if (splitedArray.length % 2 == 1) {
            subArray2[subArray2.length - 1] = 0;
        } else {
            subArray2[subArray2.length - 1] = splitedArray[splitedArray.length - 1];
        }
    }

    /**
     *
     * @param p
     * @param q
     * @return
     */
    public double[] polyMult(double[] p, double[] q) {
        //original method for multiplying 2 polynomial. W(m,n) = m*n with m is length of coefficient q, and so on
        double[] multiplication = new double[p.length + q.length - 1];
        double[] arrayShortLength, arrayLongLength;
        if (p.length == q.length) {
            arrayLongLength = p;
            arrayShortLength = q;
        } else {
            if (p.length > q.length) {
                arrayLongLength = p;
                arrayShortLength = q;
            } else {
                arrayLongLength = q;
                arrayShortLength = p;
            }
        }
        double[][] temp = new double[arrayShortLength.length][arrayLongLength.length];
        for (int i = 0; i < arrayShortLength.length; i++) {
            for (int j = 0; j < arrayLongLength.length; j++) {
                temp[i][j] = arrayShortLength[i] * arrayLongLength[j];
            }
        }
        int rowHand = 0, columnHand = 0, power = 0;
        while (rowHand < arrayShortLength.length) {
            int k = 0, h = columnHand;
            while (k <= rowHand) {
                multiplication[power] += temp[k][h];
                ++k;
                --h;
            }
            ++power;
            ++rowHand;
            ++columnHand;
        }
        rowHand = 1;
        while (columnHand < arrayLongLength.length) {
            int k = 0, h = columnHand;
            while (k < arrayShortLength.length) {
                multiplication[power] += temp[k][h];
                ++k;
                --h;
            }
            ++power;
            ++columnHand;
        }
        --columnHand;
        while (rowHand < arrayShortLength.length) {
            int k = rowHand, h = columnHand;
            while (k < arrayShortLength.length) {
                multiplication[power] += temp[k][h];
                ++k;
                --h;
            }
            ++power;
            ++rowHand;
        }
        return multiplication;
    }

    /**
     * multiply 2 polynomial of same size using divide and conquer method. w(n)
     * = n^log2(3)
     *
     * @param p coefficient array of polynomial
     * @param q coefficient array of polynomial
     * @param n p.length
     * @return a 1 dimension array of input size 2n - 1
     */
    private double[] polyMult1(double[] p, double[] q, int n) {
        if (n == 1) {
            double[] tempArray = new double[n];
            tempArray[0] = p[0] * q[0];
            return tempArray;
        } else {
            MathFormulas caculator = new MathFormulas();
            int d = caculator.approximationToInteger(n / 2.0);
            double[] tempArray1 = new double[d];
            double[] tempArray2 = new double[d];
            double[] tempArray3 = new double[d];
            double[] tempArray4 = new double[d];
            split(p, tempArray1, tempArray2, d);
            split(q, tempArray3, tempArray4, d);
            double[] r = new double[d], t = new double[d], h = new double[d];
            r = polyMult1(tempArray2, tempArray4, d);
            t = polyMult1(arrayTool.sum(tempArray1, tempArray2), arrayTool.sum(tempArray3, tempArray4), d);
            h = polyMult1(tempArray1, tempArray3, d);
            double[] sum = new double[2 * p.length - 1];
            for (int i = 0; i < d; i++) {
                sum[i] = h[i];
            }
            if (h.length > d) {
                for (int i = d; i < h.length; i++) {
                    sum[i] = h[i] + t[i - d] - (h[i - d] + r[i - d]);
                }
                for (int i = h.length; i < 2 * d; i++) {
                    sum[i] = t[i - d] - (h[i - d] + r[i - d]);
                }
            } else {
                for (int i = d; i < 2 * d; i++) {
                    sum[i] = t[i - d] - (h[i - d] + r[i - d]);
                }
            }
            if (t.length > d) {
                for (int i = d; i < t.length; i++) {
                    sum[i + d] = t[i] - (h[i] + r[i]) + r[i - d];
                }
                for (int i = t.length; i + d < sum.length; i++) {
                    sum[i + d] = r[i - d];
                }
            } else {
                for (int i = 2 * d; i < sum.length; i++) {
                    sum[i] = r[i - 2 * d];
                }
            }
            return sum;
        }
    }

    /**
     * multiply 2 polynomial of different size using divide and conquer method.
     * W(m,n) = n*m^log2(3/2)
     *
     * @param q coefficient array of polynomial
     * @param p coefficient array of polynomial
     * @return polynomial product, length = q.length + p.length -1
     */
    public double[] polyMult2(double[] q, double[] p) {
        double[] arrayShortLength, arrayLongLength;
        double[] multiplication = new double[q.length + p.length - 1];
        if (p.length == q.length) {
            arrayLongLength = p;
            arrayShortLength = q;
        } else {
            if (p.length > q.length) {
                arrayLongLength = p;
                arrayShortLength = q;
            } else {
                arrayLongLength = q;
                arrayShortLength = p;
            }
        }
        int k = arrayLongLength.length / arrayShortLength.length;
        double[][] subArray = new double[k][arrayShortLength.length];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < arrayShortLength.length; j++) {
                subArray[i][j] = arrayLongLength[j + i * arrayShortLength.length];
            }
        }
        int tempLength = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            double[] temp = polyMult1(subArray[i], arrayShortLength, arrayShortLength.length);
            tempLength = temp.length;
            for (int j = 0; j < temp.length; j++) {
                multiplication[i * arrayShortLength.length + j] += temp[j];
            }
        }
        double[] temp2 = new double[arrayLongLength.length - k * arrayShortLength.length];
        for (int i = k * arrayShortLength.length; i < arrayLongLength.length; i++) {
            temp2[i - k * arrayShortLength.length] = arrayLongLength[i];
        }
        double[] temp3 = polyMult(temp2, arrayShortLength);
        for (int i = k * arrayShortLength.length; i < multiplication.length; i++) {
            multiplication[i] += temp3[i - k * arrayShortLength.length];
        }
        return multiplication;
    }
}
