/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi;

import java.util.Random; 
import java.util.Scanner;

public class Array {

    /**
     * max, min of an array
     */
    private double max, min;

    private int maxInt, minInt;

    /**
     * variables finding max and min between 2 numbers. This helps paring of
     * maxMin3's function
     */
    private double p = 0, q = 0;
    private int pInt = 0, qInt = 0;

    /**
     * @return max of an array
     */
    public double getMax() {
        return max;
    }

    /**
     * @return max of an array
     */
    public int getMaxInt() {
        return maxInt;
    }

    /**
     * @return max of an array
     */
    public int getMinInt() {
        return minInt;
    }

    /**
     * @return min of an array
     */
    public double getMin() {
        return max;
    }

    /**
     * @return min of 2 numbers
     */
    private double getQ() {
        return q;
    }

    /**
     * @return max of 2 numbers
     */
    private double getP() {
        return p;
    }

    /**
     * @return min of 2 numbers
     */
    private int getQInt() {
        return qInt;
    }

    /**
     * @return max of 2 numbers
     */
    private int getPInt() {
        return pInt;
    }

    /**
     * generate all the element in the array the value of 1
     *
     * @param array is a 2 dimension array
     * @return double[][] array with value of 1
     */
    public double[][] generate1(double[][] array) {

        for (double[] array1 : array) {
            for (int j = 0; j < array[0].length; j++) {
                array1[j] = 1;
            }
        }
        return array;
    }

    /**
     * generate all the element in the array the value of 0
     *
     * @param array is a 2 dimension array
     * @return double[][] array with value of 0
     */
    public double[][] generate0(double[][] array) {

        for (double[] array1 : array) {
            for (int j = 0; j < array[0].length; j++) {
                array1[j] = 0;
            }
        }
        return array;
    }

    /**
     * generate all the element in the array the value of 1
     *
     * @param array
     * @return double[] array with all values of 1
     */
    public double[] generate1(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }
        return array;
    }

    /**
     * generate all the element in the array the value of 0
     *
     * @param array
     * @return double[] array with all values of 0
     */
    public double[] generate0(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
        return array;
    }

    /**
     * generate all the element in the array random values
     *
     * @param array
     * @return array
     */
    public int[] generateRan(int[] array) {
        Random generate = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = generate.nextInt(1000) + 1000;
        }
        return array;
    }

    /**
     * generate all the element in the array random values
     *
     * @param array
     * @return array
     */
    public double[] generateRan(double[] array) {
        Random generate = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = (generate.nextInt(1000) + 1000) * (generate.nextDouble());
        }
        return array;
    }

    /**
     * generate all the element with its index
     *
     * @param array
     * @return array
     */
    public int[] generate(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        return array;
    }

    /**
     * generate all the element with its index
     *
     * @param array
     * @return array
     */
    public double[] generate(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        return array;
    }

    /**
     * scan value for elements in the array
     *
     * @param array
     * @return array with elements scanned
     */
    public int[] scan(int[] array) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }

    /**
     * scan value for elements in the array
     *
     * @param array
     * @return array with elements scanned
     */
    public double[] scan(double[] array) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextDouble();
        }
        return array;
    }

    /**
     * scan value for elements in the array
     *
     * @param array
     * @return array with elements scanned
     */
    public int[][] scan(int[][] array) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        return array;
    }

    /**
     * scan value for elements in the array
     *
     * @param array
     * @return array with elements scanned
     */
    public double[][] scan(double[][] array) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = sc.nextDouble();
            }
        }
        return array;
    }

    /**
     * generate all the element with sum of its column index and row index
     *
     * @param array
     * @return array
     */
    public int[][] generate(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = i + j;
            }
        }
        return array;
    }

    /**
     * generate all the element with sum of its column index and row index
     *
     * @param array
     * @return array
     */
    public double[][] generate(double[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = i + j;
            }
        }
        return array;
    }

    /**
     * generate all the element in the array random values
     *
     * @param array
     * @return []double array
     */
    public double[] generating(double[] array) {
        Random generate = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = generate.nextInt(1000) + 1000;
        }
        return array;
    }

    /**
     * generate all the element in the array random values
     *
     * @param array
     * @return array
     */
    public double[][] generating(double[][] array) {
        Random generate = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = generate.nextInt(1000) + 1000;
            }
        }
        return array;
    }
    
    /**
     * copy elements from array to copyArray
     * @param array
     * @param copyArray
     * @return an array copied
     */
    public double[] copy(double [] array, double[] copyArray){
        for (int i = 0; i < array.length; i++) {
            copyArray[i] = array[i];
        }
        return copyArray;
    }
    
    /**
     * copy elements from array to copyArray
     * @param array
     * @param copyArray
     * @return an array copied
     */
    public int[][] copy(int [][] array, int[][] copyArray){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
            copyArray[i][j] = array[i][j];
            }
        }
        return copyArray;
    }
    
    /**
     * copy elements from array to copyArray
     * @param array
     * @param copyArray
     * @return an array copied
     */
    public double [][] copy(double [][] array, double [][] copyArray){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
            copyArray[i][j] = array[i][j];
            }
        }
        return copyArray;
    }
    
    /**
     * copy elements from array to copyArray
     * @param array
     * @param copyArray
     * @return an array copied
     */
    public int[] copy(int [] array, int[] copyArray){
        for (int i = 0; i < array.length; i++) {
            copyArray[i] = array[i];
        }
        return copyArray;
    }

    /**
     * display all elements in the array in a single column
     *
     * @param array
     */
    public void Display(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Array[" + i + "] = " + array[i]);
        }
    }

    /**
     * display all elements in the array
     *
     * @param array
     */
    public void Display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Array[" + i + "] = " + array[i]);
        }
    }

    /**
     * compare 2 arrays.
     *
     * @param array1
     * @param array2
     * @return true if 2 arrays have the same elements; false if 2 arrays have
     * more than 1 different element
     */
    public boolean compare(double[][] array1, double[][] array2) {
        if (array1.length == array2.length && array1[0].length == array2[0].length) {
            for (int i = 0; i < array2.length; i++) {
                for (int j = 0; j < array2[0].length; j++) {
                    if (array1[i][j] != array2[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * display all elements in the array
     *
     * @param array
     */
    public void Display(double[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print("Array[" + i + "][" + j + "] = " + array[i][j] + "  ");
            }
            System.out.println("");
        }
    }

    /**
     * display all elements in the array
     *
     * @param array
     */
    public void Display(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print("Array[" + i + "][" + j + "] = " + array[i][j] + "  ");
            }
            System.out.println("");
        }
    }

    /**
     * @param array
     * @return sum of all elements in the array
     */
    public int sum(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        return result;
    }

    /**
     * @param array
     * @return sum of all elements in the array
     */
    public double sum(double[] array) {
        double result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        return result;
    }

    /**
     * add all elements lying on the same row
     *
     * @param array
     * @return an array that its elements is the sum of all elements lying on
     * the same row in a two dimension array
     */
    public int[] sumRow(int[][] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = sum(array[i]);
        }
        return result;
    }

    /**
     * add all elements lying on the same row
     *
     * @param array
     * @return an array that its elements is the sum of all elements lying on
     * the same row in a two dimension array
     */
    public double[] sumRow(double[][] array) {
        double[] result = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = sum(array[i]);
        }
        return result;
    }

    /**
     * add elements from array1 to array2
     *
     * @param array1
     * @param array2
     * @return the one dimension array after adding array1 into array2. This
     * array has its length equal to the array that has larger length
     */
    public double[] sum(double[] array1, double[] array2) {
        double[] sumArray = new double[array1.length];
        for (int i = 0; i < array2.length; i++) {
            sumArray[i] = array1[i] + array2[i];
        }
        if (array1.length == array2.length) {
            return sumArray;
        } else {
            if (array1.length > array2.length) {
                System.arraycopy(array1, array2.length, sumArray, array2.length, array1.length - array2.length);
            } else {
                System.arraycopy(array2, array1.length, sumArray, array1.length, array2.length - array1.length);
            }
            return sumArray;
        }
    }

    /**
     * array1 subtracts array2.
     *
     * @param array1
     * @param array2
     * @return subtraction of 2 arrays.
     */
    public double[] subtract(double[] array1, double[] array2) {
        int n; //length of subtracted array
        if (array1.length > array2.length) {
            n = array1.length;
        } else {
            n = array2.length;
        }
        double[] subtractedArray = new double[n], tempArray1 = new double[n], tempArray2 = new double[n];
        System.arraycopy(array1, 0, tempArray1, 0, array1.length);
        for (int i = array1.length; i < tempArray1.length; i++) {
            tempArray1[i] = 0;
        }
        System.arraycopy(array2, 0, tempArray2, 0, array2.length);
        for (int i = array2.length; i < tempArray2.length; i++) {
            tempArray2[i] = 0;
        }
        for (int i = 0; i < subtractedArray.length; i++) {
            subtractedArray[i] = tempArray1[i] - tempArray2[i];
        }
        return subtractedArray;
    }

    /**
     * original method of multiplying two array of 2 dimension. W =
     * array2.length*array2[0].length*array1.length.
     *
     * @param array1
     * @param array2
     * @return product of 2 array.
     */
    public double[][] mult(double[][] array1, double[][] array2) {
        if (array1[0].length != array2.length) {
            throw new IllegalArgumentException("We can't multiply these two arrays.");
        } else {
            double[][] result = new double[array1.length][array2[0].length];
            for (int i = 0; i < array1.length; i++) {
                for (int j = 0; j < array2[0].length; j++) {
                    for (int k = 0; k < array1[0].length; k++) {
                        result[i][j] += array1[i][k] * array2[k][j];
                    }
                }
            }
            return result;
        }
    }
    /**
     * multiply array with a number
     * @param array
     * @param n times
     * @return array*n
     */
    public double [] mult(double[] array, double n){
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i]*n;
        }
        return array;
    }
    
    /**
     * multiply array with a number
     * @param array
     * @param n times
     * @return array*n
     */
    public int [] mult(int[] array, int n){
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i]*n;
        }
        return array;
    }

    /**
     * select the n-th smallest element in the array based on divide and conquer
     * paradigm. B(n,t) and A(n,t) is of O(n); B(n,t) = n+1; A(n,t) <= 4n.
     *
     * @param array
     * @param NthSmallest 0 smaller than NthSmallest smaller than (array.length
     * - 1).
     * @param low Initially: 0.
     * @param high Initially: array.length - 1.
     * @return the value of n-th smallest element in the array.
     */
    public double select(double[] array, int NthSmallest, int low, int high) {
        MathFormulas partition = new MathFormulas();
        int position = partition.partition(array, low, high, low);
        if (NthSmallest == position + 1) {
            System.out.println("The " + NthSmallest + "-th smallest element in the array is: ");
            return array[position];
        } else {
            if (NthSmallest < position + 1) {
                return select(array, NthSmallest, low, position - 1);
            } else {
                return select(array, NthSmallest, position + 1, high);
            }
        }
    }

    /**
     * select the n-th smallest element in the array based on divide and conquer
     * paradigm. B(n,t) and A(n,t) is of O(n); B(n,t) = n+1; A(n,t) <= 4n.
     *
     * @param array
     * @param NthSmallest 0 smaller than NthSmallest smaller than (array.length
     * - 1).
     * @param low Initially: 0.
     * @param high Initially: array.length - 1.
     * @return the value of n-th smallest element in the array.
     */
    public int select(int[] array, int NthSmallest, int low, int high) {
        MathFormulas partition = new MathFormulas();
        int position = partition.partition(array, low, high, low);
        if (NthSmallest == position + 1) {
            System.out.println("The " + NthSmallest + "-th smallest element in the array is: ");
            return array[position];
        } else {
            if (NthSmallest < position + 1) {
                return select(array, NthSmallest, low, position - 1);
            } else {
                return select(array, NthSmallest, position + 1, high);
            }
        }
    }

    /**
     * finding max and min of 2 numbers
     *
     * @param a
     * @param b
     */
    private void paring(double a, double b) {
        if (a > b) {
            p = a;
            q = b;
        } else {
            p = b;
            q = a;
        }
    }

    /**
     * finding max min by paring 2 successive elements of an array, then compare
     * them with assigned max, min
     *
     * @param array
     */
    public void maxMin3(double[] array) {
        if (array.length % 2 == 0) {
            max = array[0];
            min = array[1];
            for (int i = 0; i < array.length - 1; i = i + 2) {
                paring(array[i], array[i + 1]);
                if (p > getMax()) {
                    max = getP();
                }
                if (q < getMin()) {
                    min = getQ();
                }
            }
        } else {
            max = array[0];
            min = array[0];
            for (int i = 1; i < array.length - 1; i = i + 2) {
                paring(array[i], array[i + 1]);
                if (p > getMax()) {
                    max = getP();
                }
                if (q < getMin()) {
                    min = getQ();
                }
            }
        }
    }

    /**
     * finding max and min of 2 numbers
     *
     * @param a
     * @param b
     */
    private void paringInt(int a, int b) {
        if (a > b) {
            pInt = a;
            qInt = b;
        } else {
            pInt = b;
            qInt = a;
        }
    }

    /**
     * finding max min by paring 2 successive elements of an array, then compare
     * them with assigned max, min
     *
     * @param array
     */
    public void maxMin3(int[] array) {
        if (array.length % 2 == 0) {
            maxInt = array[0];
            minInt = array[1];
            for (int i = 0; i < array.length - 1; i = i + 2) {
                paringInt(array[i], array[i + 1]);
                if (pInt > getMaxInt()) {
                    maxInt = getPInt();
                }
                if (qInt < getMinInt()) {
                    minInt = getQInt();
                }
            }
        } else {
            maxInt = array[0];
            minInt = array[0];
            for (int i = 1; i < array.length - 1; i = i + 2) {
                paringInt(array[i], array[i + 1]);
                if (pInt > getMaxInt()) {
                    maxInt = getPInt();
                }
                if (qInt < getMinInt()) {
                    minInt = getQInt();
                }
            }
        }
    }

    /**
     * merge 2 seperated sub arrays in increasing order
     *
     * @param array
     * @param low initially = 0
     * @param high initially = array.length - 1
     * @param x pivot element of large array.
     * @return a sorted large array
     */
    private int[] mergeI(int[] array, int low, int high, int x) {
        int pointer1 = low;
        int pointer2 = x + 1;
        int pointer = low;
        int[] temp = new int[array.length];
        while (pointer1 <= x && pointer2 <= high) {
            if (array[pointer1] <= array[pointer2]) {
                temp[pointer] = array[pointer1];
                pointer1 += 1;
            } else {
                temp[pointer] = array[pointer2];
                pointer2 += 1;
            }
            pointer += 1;
        }
        if (pointer1 > x) {
            for (int k = pointer2; k <= high; k++) {
                temp[pointer] = array[k];
                pointer += 1;
            }
        } else {
            for (int k = pointer1; k <= x; k++) {
                temp[pointer] = array[k];
                pointer += 1;
            }
        }
        for (int i = low; i <= high; i++) {
            array[i] = temp[i];
        }

        return array;
    }

    /**
     * sort array increasingly
     *
     * @param array
     * @param low initially = 0
     * @param high initially = array.length - 1
     * @param x pivot element of large array.
     * @return a sorted array
     */
    public int[] mergeSortI(int[] array, int low, int high) {
        if (low < high) {
            int mid = (high + low) / 2;
            mergeSortI(array, low, mid);
            mergeSortI(array, mid + 1, high);
            mergeI(array, low, high, mid);
        }
        return array;
    }

    /**
     * merge 2 seperated sub arrays in increasing order
     *
     * @param array
     * @param low initially = 0
     * @param high initially = array.length - 1
     * @param x pivot element of large array.
     * @return a sorted large array
     */
    private double[] mergeI(double[] array, int low, int high, int x) {
        int pointer1 = low;
        int pointer2 = x + 1;
        int pointer = low;
        double[] temp = new double[array.length];
        while (pointer1 <= x && pointer2 <= high) {
            if (array[pointer1] <= array[pointer2]) {
                temp[pointer] = array[pointer1];
                pointer1 += 1;
            } else {
                temp[pointer] = array[pointer2];
                pointer2 += 1;
            }
            pointer += 1;
        }
        if (pointer1 > x) {
            for (int k = pointer2; k <= high; k++) {
                temp[pointer] = array[k];
                pointer += 1;
            }
        } else {
            for (int k = pointer1; k <= x; k++) {
                temp[pointer] = array[k];
                pointer += 1;
            }
        }
        for (int i = low; i <= high; i++) {
            array[i] = temp[i];
        }

        return array;
    }

    /**
     * sort array increasingly
     *
     * @param array
     * @param low initially = 0
     * @param high initially = array.length - 1
     * @param x pivot element of large array.
     * @return a sorted array
     */
    public double[] mergeSortI(double[] array, int low, int high) {
        if (low < high) {
            int mid = (high + low) / 2;
            mergeSortI(array, low, mid);
            mergeSortI(array, mid + 1, high);
            mergeI(array, low, high, mid);
        }
        return array;
    }

    /**
     * merge 2 seperated sub arrays in decreasing order
     *
     * @param array
     * @param low initially = 0
     * @param high initially = array.length - 1
     * @param x pivot element of large array.
     * @return a sorted large array
     */
    private double[] mergeD(double[] array, int low, int high, int x) {
        int pointer1 = low;
        int pointer2 = x + 1;
        int pointer = low;
        double[] temp = new double[array.length];
        while (pointer1 <= x && pointer2 <= high) {
            if (array[pointer1] <= array[pointer2]) {
                temp[pointer] = array[pointer2];
                pointer2 += 1;
            } else {
                temp[pointer] = array[pointer1];
                pointer1 += 1;
            }
            pointer += 1;
        }
        if (pointer1 > x) {
            for (int k = pointer2; k <= high; k++) {
                temp[pointer] = array[k];
                pointer += 1;
            }
        } else {
            for (int k = pointer1; k <= x; k++) {
                temp[pointer] = array[k];
                pointer += 1;
            }
        }
        for (int i = low; i <= high; i++) {
            array[i] = temp[i];
        }

        return array;
    }

    /**
     * sort array decreasingly
     *
     * @param array
     * @param low initially = 0
     * @param high initially = array.length - 1
     * @param x pivot element of large array.
     * @return a sorted array
     */
    public double[] mergeSortD(double[] array, int low, int high) {
        if (low < high) {
            int mid = (high + low) / 2;
            mergeSortD(array, low, mid);
            mergeSortD(array, mid + 1, high);
            mergeD(array, low, high, mid);
        }
        return array;
    }

    /**
     * merge 2 seperated sub arrays in decreasing order
     *
     * @param array
     * @param low initially = 0
     * @param high initially = array.length - 1
     * @param x pivot element of large array.
     * @return a sorted large array
     */
    private int[] mergeD(int[] array, int low, int high, int x) {
        int pointer1 = low;
        int pointer2 = x + 1;
        int pointer = low;
        int[] temp = new int[array.length];
        while (pointer1 <= x && pointer2 <= high) {
            if (array[pointer1] <= array[pointer2]) {
                temp[pointer] = array[pointer2];
                pointer2 += 1;
            } else {
                temp[pointer] = array[pointer1];
                pointer1 += 1;
            }
            pointer += 1;
        }
        if (pointer1 > x) {
            for (int k = pointer2; k <= high; k++) {
                temp[pointer] = array[k];
                pointer += 1;
            }
        } else {
            for (int k = pointer1; k <= x; k++) {
                temp[pointer] = array[k];
                pointer += 1;
            }
        }
        for (int i = low; i <= high; i++) {
            array[i] = temp[i];
        }

        return array;
    }

    /**
     * sort array decreasingly
     *
     * @param array
     * @param low initially = 0
     * @param high initially = array.length - 1
     * @param x pivot element of large array.
     * @return a sorted array
     */
    public int[] mergeSortD(int[] array, int low, int high) {
        if (low < high) {
            int mid = (high + low) / 2;
            mergeSortD(array, low, mid);
            mergeSortD(array, mid + 1, high);
            mergeD(array, low, high, mid);
        }
        return array;
    }

    /**
     * sort an array increasing order based on insertion sort as insertion is
     * practical when the array is nearly sorted h is the distance apart when h
     * must be in bigomega(n/logn)
     *
     * @param array
     */
    public int[] shellSortI(int[] array) {
        int h = 1;
        while ((3 * h + 1) < array.length) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < array.length; i++) {
                int temp = array[i];
                int position = i - h;
                while (position >= 0 && temp < array[position]) {
                    array[position + h] = array[position];
                    position = position - h;
                }
                array[position + h] = temp;
            }
            h = (h - 1) / 3;
        }
        return array;
    }

    /**
     * sort an array increasing order based on insertion sort as insertion is
     * practical when the array is nearly sorted h is the distance apart when h
     * must be in bigomega(n/logn)
     *
     * @param array
     */
    public double[] shellSortI(double[] array) {

        int h = 1;
        while ((3 * h + 1) < array.length) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < array.length; i++) {
                double temp = array[i];
                int position = i - h;
                while (position >= 0 && temp < array[position]) {
                    array[position + h] = array[position];
                    position = position - h;
                }
                array[position + h] = temp;
            }
            h = (h - 1) / 3;
        }
        return array;
    }

    /**
     * sort an array in creasing order based on insertion sort as insertion is
     * practical when the array is nearly sorted h is the distance apart when h
     * must be in bigomega(n/logn)
     *
     * @param array
     */
    public double[] shellSortD(double[] array) {
        int h = 1;
        while ((3 * h + 1) < array.length) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < array.length; i++) {
                double temp = array[i];
                int position = i - h;
                while (position >= 0 && temp > array[position]) {
                    array[position + h] = array[position];
                    position = position - h;
                }
                array[position + h] = temp;
            }
            h = (h - 1) / 3;
        }
        return array;
    }

    /**
     * sort an array in creasing order based on insertion sort as insertion is
     * practical when the array is nearly sorted h is the distance apart when h
     * must be in bigomega(n/logn)
     *
     * @param array
     */
    public int[] shellSortD(int[] array) {
        int h = 1;
        while ((3 * h + 1) < array.length) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < array.length; i++) {
                int temp = array[i];
                int position = i - h;
                while (position >= 0 && temp > array[position]) {
                    array[position + h] = array[position];
                    position = position - h;
                }
                array[position + h] = temp;
            }
            h = (h - 1) / 3;
        }
        return array;
    }

    /**
     * sort array in increasing order practical when there is a large number of
     * repeated elements m: number of distinct values B(n) = Bigtheta(n+m^2);
     * W(n) and A(n) = bigtheta(nm) with n is array.length Best case: n-m+1
     * minimum value Worst case: n-m+1 maximum value
     *
     * @param array
     */
    public double[] bingoSortI(double[] array) {
        maxMin3(array);
        double bingo = getMin(), nextBingo = getMax();
        int position = 0;
        while (bingo < nextBingo) {
            int startPosi = position;
            for (int i = startPosi; i < array.length; i++) {
                if (array[i] == bingo) {
                    double temp = array[position];
                    array[position] = array[i];
                    array[i] = temp;
                    position += 1;
                } else {
                    if (array[i] < nextBingo) {
                        nextBingo = array[i];
                    }
                }
            }
            bingo = nextBingo;
            nextBingo = getMax();
        }
        return array;
    }

    /**
     * sort array in increasing order practical when there is a large number of
     * repeated elements m: number of distinct values B(n) = Bigtheta(n+m^2);
     * W(n) and A(n) = bigtheta(nm) with n is array.length Best case: n-m+1
     * minimum value Worst case: n-m+1 maximum value
     *
     * @param array
     */
    public int[] bingoSortI(int[] array) {
        maxMin3(array);
        int bingo = getMinInt(), nextBingo = getMaxInt();
        int position = 0;
        while (bingo < nextBingo) {
            int startPosi = position;
            for (int i = startPosi; i < array.length; i++) {
                if (array[i] == bingo) {
                    int temp = array[position];
                    array[position] = array[i];
                    array[i] = temp;
                    position += 1;
                } else {
                    if (array[i] < nextBingo) {
                        nextBingo = array[i];
                    }
                }
            }
            bingo = nextBingo;
            nextBingo = getMaxInt();
        }
        return array;
    }

    /**
     * sort array in increasing order practical when there is a large number of
     * repeated elements m: number of distinct values B(n) = Bigtheta(n+m^2);
     * W(n) and A(n) = bigtheta(nm) with n is array.length Best case: n-m+1
     * minimum value Worst case: n-m+1 maximum value
     *
     * @param array
     */
    public int[] bingoSortD(int[] array) {
        maxMin3(array);
        int bingo = getMaxInt(), nextBingo = getMinInt();
        int position = 0;
        while (bingo > nextBingo) {
            int startPosi = position;
            for (int i = startPosi; i < array.length; i++) {
                if (array[i] == bingo) {
                    int temp = array[position];
                    array[position] = array[i];
                    array[i] = temp;
                    position += 1;
                } else {
                    if (array[i] > nextBingo) {
                        nextBingo = array[i];
                    }
                }
            }
            bingo = nextBingo;
            nextBingo = getMinInt();
        }
        return array;
    }

    /**
     * sort array in increasing order practical when there is a large number of
     * repeated elements m: number of distinct values B(n) = Bigtheta(n+m^2);
     * W(n) and A(n) = bigtheta(nm) with n is array.length Best case: n-m+1
     * minimum value Worst case: n-m+1 maximum value
     *
     * @param array
     */
    public double[] bingoSortD(double[] array) {
        maxMin3(array);
        double bingo = getMaxInt(), nextBingo = getMinInt();
        int position = 0;
        while (bingo > nextBingo) {
            int startPosi = position;
            for (int i = startPosi; i < array.length; i++) {
                if (array[i] == bingo) {
                    double temp = array[position];
                    array[position] = array[i];
                    array[i] = temp;
                    position += 1;
                } else {
                    if (array[i] > nextBingo) {
                        nextBingo = array[i];
                    }
                }
            }
            bingo = nextBingo;
            nextBingo = getMinInt();
        }
        return array;
    }

    /**
     * placing a[low] to the right position in the array as well as elements
     * smaller than a[low] to the left of its right position and so on
     *
     * @param array
     * @param low
     * @param high
     * @param position
     * @return
     */
    private int partitionI(double[] array, int low, int high, int position) {
        int moveright = low;
        int moveleft = high + 1;
        double x = array[low];
        double temp;
        while (moveright < moveleft) {
            do {
                moveleft = moveleft - 1;
            } while (array[moveleft] > x);
            do {
                moveright = moveright + 1;
            } while (moveright < array.length && array[moveright] < x);
            if (moveright < moveleft) {
                temp = array[moveleft];
                array[moveleft] = array[moveright];
                array[moveright] = temp;
            }
        }
        position = moveleft;
        array[low] = array[position];
        array[position] = x;
        return position;
    }

    /**
     * sort array in increasing order
     *
     * @param array
     * @param low initially = 0
     * @param high initially = array.length - 1
     * @return
     */
    public double[] quickSortI(double[] array, int low, int high) {
        if (low < high) {
            int position = partitionI(array, low, high, low);
            quickSortI(array, low, position - 1);
            quickSortI(array, position + 1, high);
        }
        return array;
    }

    /**
     * placing a[low] to the right position in the array as well as elements
     * larger than a[low] to the left of its right position and so on
     *
     * @param array
     * @param low
     * @param high
     * @param position
     * @return
     */
    private int partitionD(double[] array, int low, int high, int position) {
        int moveright = low;
        int moveleft = high + 1;
        double x = array[low];
        double temp;
        while (moveright < moveleft) {
            do {
                moveleft = moveleft - 1;
            } while (array[moveleft] < x);
            do {
                moveright = moveright + 1;
            } while (moveright < array.length && array[moveright] > x);
            if (moveright < moveleft) {
                temp = array[moveleft];
                array[moveleft] = array[moveright];
                array[moveright] = temp;
            }
        }
        position = moveleft;
        array[low] = array[position];
        array[position] = x;
        return position;
    }

    /**
     * sort array in decreasing order
     *
     * @param array
     * @param low initially = 0
     * @param high initially = array.length - 1
     * @return
     */
    public double[] quickSortD(double[] array, int low, int high) {
        if (low < high) {
            int position = partitionD(array, low, high, low);
            quickSortD(array, low, position - 1);
            quickSortD(array, position + 1, high);
        }
        return array;
    }

    /**
     * placing a[low] to the right position in the array as well as elements
     * smaller than a[low] to the left of its right position and so on
     *
     * @param array
     * @param low
     * @param high
     * @param position
     * @return
     */
    private int partitionI(int[] array, int low, int high, int position) {
        int moveright = low;
        int moveleft = high + 1;
        int x = array[low];
        int temp;
        while (moveright < moveleft) {
            do {
                moveleft = moveleft - 1;
            } while (array[moveleft] > x);
            do {
                moveright = moveright + 1;
            } while (moveright < array.length && array[moveright] < x);
            if (moveright < moveleft) {
                temp = array[moveleft];
                array[moveleft] = array[moveright];
                array[moveright] = temp;
            }
        }
        position = moveleft;
        array[low] = array[position];
        array[position] = x;
        return position;
    }

    /**
     * sort array in increasing order
     *
     * @param array
     * @param low initially = 0
     * @param high initially = array.length - 1
     * @return
     */
    public int[] quickSortI(int[] array, int low, int high) {
        if (low < high) {
            int position = partitionI(array, low, high, low);
            quickSortI(array, low, position - 1);
            quickSortI(array, position + 1, high);
        }
        return array;
    }

    /**
     * placing a[low] to the right position in the array as well as elements
     * larger than a[low] to the left of its right position and so on
     *
     * @param array
     * @param low
     * @param high
     * @param position
     * @return
     */
    private int partitionD(int[] array, int low, int high, int position) {
        int moveright = low;
        int moveleft = high + 1;
        int x = array[low];
        int temp;
        while (moveright < moveleft) {
            do {
                moveleft = moveleft - 1;
            } while (array[moveleft] < x);
            do {
                moveright = moveright + 1;
            } while (moveright < array.length && array[moveright] > x);
            if (moveright < moveleft) {
                temp = array[moveleft];
                array[moveleft] = array[moveright];
                array[moveright] = temp;
            }
        }
        position = moveleft;
        array[low] = array[position];
        array[position] = x;
        return position;
    }

    /**
     * sort array in decreasing order
     *
     * @param array
     * @param low initially = 0
     * @param high initially = array.length - 1
     * @return
     */
    public int[] quickSortD(int[] array, int low, int high) {
        if (low < high) {
            int position = partitionD(array, low, high, low);
            quickSortD(array, low, position - 1);
            quickSortD(array, position + 1, high);
        }
        return array;
    }

    /**
     * Calculate rank of a matrix
     *
     * @param matrix
     * @return det of a matrix
     */
    public double det(double[][] matrix) { //caculating det of a matrix recursively
        if (matrix.length == 1) {
            return matrix[0][0];
        } else {
            if (matrix.length == 2) {
                return matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
            } else {
                double res = 0;
                for (int k = 0; k < matrix.length; k++) {
                    double[][] childMatrix = new double[matrix.length - 1][matrix.length - 1];
                    for (int i = 0; i < matrix.length; i++) {
                        for (int j = 1; j < matrix.length; j++) {
                            if (i > k) {
                                childMatrix[i - 1][j - 1] = matrix[i][j];
                            }
                            if (i < k) {
                                childMatrix[i][j - 1] = matrix[i][j];
                            }
                        }
                    }
                    int coefficient = 1;
                    if (k % 2 == 1) {
                        coefficient = -1;
                    }
                    res += coefficient * matrix[k][0] * det(childMatrix);
                }
                return res;
            }
        }
    }

    /**
     * provide the optimal parenthesization when multiply M-i and M-j based on
     * dynamic programming method.
     *
     * @param d all array length
     * @param m the least number of multiplications of M-i and M-j
     * @param firstCut the first cut which leads to optimal multiplication of
     * M-i and M-j
     */
    private void OptimalParenthesization(int[] d, int[][] m, int[][] firstCut) {
        for (int i = 0; i < firstCut.length; i++) {
            m[i][i] = 0;
        }
        for (int diag = 1; diag < firstCut.length; diag++) { //diag is diagonal. 
            for (int i = 0; i < firstCut.length - diag; i++) { // caculate min mults when mult M-i*M-j; M: Matrix
                int j = i + diag;
                int min = m[i + 1][j] + d[i] * d[i + 1] * d[j + 1];
                int tempCut = i;
                for (int k = i + 1; k < j; k++) {
                    int tempMin = m[i][k] + m[k + 1][j] + d[i] * d[k + 1] * d[j + 1];
                    if (tempMin < min) {
                        min = tempMin;
                        tempCut = k;
                    }
                }
                m[i][j] = min;
                firstCut[i][j] = tempCut;
            }
        }
    }

    /**
     * recursively compute multiplication of M-0 and M-(n-1) with optimal
     * parenthesization
     *
     * @param i
     * @param j
     * @param firstCut
     * @param lists list of [][]double array
     * @return product of chained matrix
     */
    private double[][] chainedMatrixProduct(int i, int j, int[][] firstCut, TwoArrayLinkedList lists) {
        if (j > i) {
            double[][] x = chainedMatrixProduct(i, firstCut[i][j], firstCut, lists);
            double[][] y = chainedMatrixProduct(firstCut[i][j] + 1, j, firstCut, lists);
            return mult(x, y);
        } else {
            return lists.find(i).getArray();
        }
    }

    /**
     * this method allows user to calculate the product of a given chained
     * matrix
     *
     * @param lists - the list of chained matrix
     * @return null if the given chained can't produce a product product
     */
    public double[][] chainedMatrixProd(TwoArrayLinkedList lists) {
        TwoArrayList temp = lists.getLast();
        int[] d = new int[lists.getLength() + 1]; // all array length
        int[][] m = new int[lists.getLength()][lists.getLength()], // the least number of multiplications of M-i and M-j
                firstCut = new int[lists.getLength()][lists.getLength()]; // the first cut which leads to optimal multiplication of M-i and M-j
        while (temp.getPrevious() != null) {
            if (temp.getPrevious().getArray().length != temp.getArray()[0].length) {
                System.out.println("We can't multiply these chained matrix array. Error at: (array-" + temp.getIndex() + ").[0]length and (array-" + (temp.getIndex() + 1) + ").length.");
                return null;
            } else {
                d[temp.getIndex()] = temp.getArray().length;
                temp = temp.getPrevious();
            }
        }
        if (temp.getNext().getArray()[0].length != temp.getArray().length) {
            System.out.println("We can't multiply these chained matrix array. Error at: (array-" + (temp.getIndex() - 1) + ").[0]length and (array-" + temp.getIndex() + ").length.");
            return null;
        } else {
            d[lists.getLength() - 1] = temp.getArray().length;
            d[lists.getLength()] = temp.getArray()[0].length;
            OptimalParenthesization(d, m, firstCut);
            double[][] a = chainedMatrixProduct(0, lists.getLength() - 1, firstCut, lists);
            return a;
        }
    }
}
