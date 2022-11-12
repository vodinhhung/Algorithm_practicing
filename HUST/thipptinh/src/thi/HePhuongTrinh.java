/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi;

import thi.Array; 
import thi.MathFormulas;
import java.util.Arrays;
import java.util.Scanner;

public class HePhuongTrinh {

    static Scanner sc = new Scanner(System.in);

    /**
     * finding zero of X of equations using GAUSS. when using this, input
     * coefficients of the equations and then numbers at the right hand of the
     * equations before calling the method phuong phap nay co the ap dung duoc
     * ca voi he vo dinh hoac vo nghiem. Do do, khong can phai tinh truoc det
     *rac roi hon gauss jordan voi khauqua trinh nghich
     * So luong phep tinh thuoc (n^3)
     *
     * @param matrix - polynomials, length = length[0] = n
     * @param rightHand - right hand numbers of equations , length = n
     */
    public double[] equatSolver(double[][] matrix, double[] rightHand) {
        MathFormulas calculator = new MathFormulas();
        equationsDisplay(matrix, rightHand);
        int q = 0, p = 0;
        while (matrix[matrix.length - 1][matrix[0].length - 2] != 0) { // reducing rows echelon form
            if (matrix[q][p] == 0) {
                int exchangingNumber = p;
                while (exchangingNumber < matrix.length && matrix[q][exchangingNumber] == 0) {
                    ++exchangingNumber;
                }
                double tempExchangeNumber = matrix[q][p];
                matrix[q][p] = matrix[q][exchangingNumber];
                matrix[q][exchangingNumber] = tempExchangeNumber;
            }
            rightHand[q] = rightHand[q] / matrix[q][p];
            double tempCoefficient = matrix[q][p];
            for (int i = p; i < matrix[0].length; i++) {
                matrix[q][i] = matrix[q][i] / tempCoefficient;
            }
            for (int i = q + 1; i < matrix.length; i++) {
                double tempCoefficient2 = matrix[i][p];
                rightHand[i] = rightHand[i] - rightHand[q] * tempCoefficient2;
                for (int j = p; j < matrix[0].length; j++) {
                    matrix[i][j] = matrix[i][j] - tempCoefficient2 * matrix[q][j];
                }
            }
            ++p;
            ++q;
        }
        double[] zeroOfEquations = new double[matrix.length];
        if (matrix[matrix.length - 1][matrix.length - 2] == 0) { //finding zero of f 
            for (int i = matrix.length - 1; i >= 0; i--) {
                double sum = 0;
                for (int j = i + 1; j < matrix.length; j++) {
                    sum += zeroOfEquations[j] * matrix[i][j];
                }
                zeroOfEquations[i] = (rightHand[i] - sum) / matrix[i][i];
                System.out.println("x[" + i + "] = " + calculator.approximation(zeroOfEquations[i]) + ". Err = " + (zeroOfEquations[i] - calculator.approximation(zeroOfEquations[i])));
            }
            return zeroOfEquations;
        } else {
            System.out.println("Khong giai duoc phuong trinh bang gauss.");
            return null;
        }
    }

    /**
     * finding zero of X of equations using Gauss-Jordan. when using this, input
     * coefficients of the equations and then numbers at the right hand of the
     * equations before calling the method
     * ap dung voi ca he vo dinh, vo nghiem va he co so phuong trinh khac so an. 
     * So luong phep tinh: n/3(n^2+3n-1) voi phep tinh chu dao la phep nhan va chia. Bigtheta thuoc (n^3)
     * @param matrix - polynomials, length = length[0] = n
     * @param rightHand - right hand numbers of equations , length = n
     */
    public double[] equatSolvers(double[][] matrix, double[] rightHand) {
        MathFormulas calculator = new MathFormulas();
        Array ArrTools = new Array();
        equationsDisplay(matrix, rightHand);
        double[] zeroOfX = new double[matrix.length]; // zero of X of equations
        double[][] skip = new double[matrix.length][matrix.length]; //skip when finding max
        double[][] skip2 = new double[matrix.length][matrix.length]; //skip when implementing principal formula
        ArrTools.generate0(skip); // initially, skip = 0
        for (int i = 0; i < matrix.length; i++) {
            double max = Integer.MIN_VALUE;
            int tempColumn = 0, tempRow = 0; // column and row of max 
            for (int j = 0; j < matrix.length; j++) { // finding max of matrix, skip if j = skip[j], k = skip[j][k]
                for (int k = 0; k < matrix[0].length; k++) {
                    if (skip[j][k] == 0) {
                        if (matrix[j][k] > max) {
                            max = matrix[j][k];
                            tempColumn = k;
                            tempRow = j;
                        }
                    }
                }
            }
            for (int j = 0; j < matrix.length; j++) { //add elements to skip. We must skip elements having the same row and column with max
                skip[j][tempColumn] = 2; //elements in the same column = 2
                skip2[j][tempColumn] = 2;
            }
            for (int j = 0; j < matrix.length; j++) { //add elements to skip. We must skip elements having the same row and column with max
                skip[tempRow][j] = 1; //elements in the same row = 1 
                skip2[tempRow][j] = 1;
            }
            for (int j = 0; j < matrix.length; j++) { //performing the principal formula
                double temp = matrix[j][tempColumn];
                for (int k = 0; k < matrix.length; k++) {
                    if (skip2[j][k] == 0) {
                        matrix[j][k] = matrix[j][k] - (matrix[tempRow][k] * temp) / max;
                    } else {
                        if (skip2[j][k] == 2) {
                            matrix[j][k] = 0;
                        }
                    }
                }
                if (j != tempRow) {
                    rightHand[j] = rightHand[j] - (rightHand[tempRow] * temp) / max;
                }
            }
            for (int j = 0; j < matrix.length; j++) { //elements in the same column of max return = 0
                skip2[tempRow][j] = 0;
            }
        }
        for (int i = 0; i < matrix.length; i++) { //finding zero of x
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    zeroOfX[i] = (rightHand[i] / matrix[i][j]);
                    System.out.println("X" + i + " = " + zeroOfX[i] + ". Err = " + (rightHand[i] / matrix[i][j] - calculator.approximation(zeroOfX[i])));
                }
            }
        }
        return zeroOfX;
    }

    /**
     * display equations
     *
     * @param matrix
     * @param rightHand
     */
    private void equationsDisplay(double[][] matrix, double[] rightHand) {
        System.out.println("He phuong trinh: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                System.out.print(matrix[i][j] + "*" + "X" + j + " + ");
            }
            System.out.print(matrix[i][matrix[0].length - 1] + "*" + "X" + (matrix[0].length - 1) + " = " + rightHand[i]);
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        System.out.print("So phuong trinh: ");
        int n = sc.nextInt();
        double[][] equationsCoefficient = new double[n][n];
        double[] rightHand = new double[n];
        Array ArrTools = new Array();
        //ArrTools.scan(equationsCoefficient);
        //ArrTools.scan(rightHand);
        equationsCoefficient[0][0] = 1;
        equationsCoefficient[0][1] = 1;
        equationsCoefficient[0][2] = -3;
        equationsCoefficient[0][3] = 2;
        equationsCoefficient[1][0] = 1;
        equationsCoefficient[1][1] = -2;
        equationsCoefficient[1][2] = 0;
        equationsCoefficient[1][3] = -1;
        equationsCoefficient[2][0] = 0;
        equationsCoefficient[2][1] = 1;
        equationsCoefficient[2][2] = 1;
        equationsCoefficient[2][3] = 3;
        equationsCoefficient[3][0] = 2;
        equationsCoefficient[3][1] = -3;
        equationsCoefficient[3][2] = 2;
        equationsCoefficient[3][3] = 0;
        rightHand[0] = 6;
        rightHand[1] = -6;
        rightHand[2] = 16;
        rightHand[3] = 6;
        HePhuongTrinh a = new HePhuongTrinh();
        a.equatSolvers(equationsCoefficient, rightHand);
    }
}
