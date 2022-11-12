/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi;

import thi.Array;     
import thi.DataExchanging;

public class MathFormulas {
    /**
     * This object Math provides some arithmetics which java doesn't provide
     * or which I have learned from algorithm of ...
     */
    
    
    /**
     * Max value of an array
     */
    double max, 

    /**
     * Min value of an array
     */
    min; 

    /**
     * instant valuable assisting MaxMin3
     */
    double p = 0,q = 0;

    /**
     * get max
     * @return max value of a double array
     */
    public double getMax() {
        return max;
    }

    /**
     * get min
     * @return min value of a double array
     */
    public double getMin() {
        return min;
    }

    /**
     * finding greatest common divisor of a and b
     * @param a - integer
     * @param b - integer
     * @return greatest common divisor of a and b
     */
    public int factorization(int a, int b) {
        int gcd = 1;
        int i = 2;
        while (i <= a) {
            if (a % i == 0 && b % i == 0) {//finding the gcd
                a /= i;
                b /= i;
                gcd *= i;
                i = 2;
            } else {
                ++i;
            }
            if (a == 1 || b == 1) {
                return gcd;
            }
        }
        return gcd;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    int gcd(int a, int b) { //finging greatest common divisor of a and b
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    int gcdpro(int a, int b) { //finging greatest common divisor of a and b; this is the fastest way
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (a % b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return b;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    int lcm(int a, int b) { // finding the least common mutiple of a and b
        return (a * b) / factorization(a, b);
    }

    /**
     *
     * @param array
     * @return
     */
    double max1(double[] array) { // the most traditional and simple way of finding max
        double max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     *
     * @param a
     * @return
     */
    int maxmin2(double[] a) {// finding max, min with best complexity is n-1
        max = a[0];
        min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            } else {
                if (a[i] < getMin()) {
                    min = a[i];
                }
            }
        }
        return 0;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    int paring(double a, double b) { // paring 2 successive elements of an array for examing whether there is a number max or min (only use for maxmin 3)
        if (a > b) {
            p = a;
            q = b;
        } else {
            p = b;
            q = a;
        }
        return 0;
    }

    /**
     *
     * @param a
     * @return
     */
    int maxmin3(double[] a) { //finding max min by paring 2 successive elements of an array, then compare them with assigned max, min; this is the most applicable way of finding max min
        if (a.length % 2 == 0) {
            max = a[0];
            min = a[1];
            for (int i = 0; i < a.length - 1; i = i + 2) {

                paring(a[i], a[i + 1]);
                if (p > getMax()) {
                    max = p;
                }
                if (q < getMin()) {
                    min = q;
                }
            }
            return 0;
        } else {
            max = a[0];
            min = a[0];
            for (int i = 1; i < a.length - 1; i = i + 2) {
                paring(a[i], a[i + 1]);
                if (p > getMax()) {
                    max = p;
                }
                if (q < getMin()) {
                    min = q;
                }
            }
            return 0;
        }
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    double paringForRecursiveMax(double a, double b) {  // compare 2 elements
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    /**
     *
     * @param a
     * @param index
     * @return
     */
    double recursivemax(double[] a, int index) { //finding max element of an array
        if (index > 1) {
            return paringForRecursiveMax(a[index - 1], recursivemax(a, index - 2));
        } else {
            return a[0];
        }
    }

    /**
     *
     * @param a
     * @param low
     * @param high
     * @param position
     * @return
     */
    public int partition(double[] a, int low, int high, int position) {
        // placing a[low] to the right position in the array as well as elements smaller than a[low] to the left of its right position and so on
        int moveright = low;
        int moveleft = high + 1;
        double x = a[low];
        double temp;
        while (moveright < moveleft) {
            do {
                moveleft = moveleft - 1;
            } while (a[moveleft] > x);
            do {
                moveright = moveright + 1;
            } while (moveright < a.length && a[moveright] < x);
            if (moveright < moveleft) {
                temp = a[moveleft];
                a[moveleft] = a[moveright];
                a[moveright] = temp;
            }
        }
        position = moveleft;
        a[low] = a[position];
        a[position] = x;
        return position;
    }
    
    /**
     * Separate the original array into 2 parts: one has all of its elements value smaller than value of position;
     * the other has all of its elements value larger than value of position. Then, put the element into the appropriate
     * position in the array.
     * @param array 
     * @param low Initially: 0.
     * @param high Initially: array.length - 1.
     * @param position Initially: low.
     * @return the position of element initially having the index low.
     */
    public int partition(int[] array, int low, int high, int position) {
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
     *
     * @param a
     * @param position
     * @return
     */
    double devideAndConquerMax(double[] a, int position) {
        // initially, position = 0;
        // every slow        
        position = partition(a, position, a.length - 1, position);
        if (position == a.length - 1) {
            return a[position];
        } else {
            return devideAndConquerMax(a, position + 1);
        }
    }

    /**
     *
     * @param a
     * @param position
     * @return
     */
    double devideAndConquerMin(double[] a, int position) {
        // initially, position = 0;
        // every slow        
        position = partition(a, 0, position, 0);
        if (position == 0) {
            return a[position];
        } else {
            return devideAndConquerMin(a, position - 1);
        }
    }

    /**
     *
     * @param array
     * @param position
     */
    void devideAndConquerMaxAndMin(double[] array, int position) {
        //every slow
        position = partition(array, position, array.length - 1, position);
        if (position == 0 || position == array.length - 1) {
            if (position == 0) {
                min = array[position];
                max = devideAndConquerMax(array, position + 1);
            } else {
                max = array[position];
                min = devideAndConquerMin(array, position - 1);
            }
        } else {
            max = devideAndConquerMax(array, position + 1);
            min = devideAndConquerMin(array, position - 1);
        }
    }

    /**
     * @param a
     * @return non-negative number
     */
    public double abs(double a) { //return absolute value of the given number
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }

    /**
     *
     * @param n
     * @param x
     * @return
     */
    double righttoleft(int n, double x) {
        double acpow = 1;
        if (n != 0) {
            while (n > 1) {
                if (n % 2 == 1) {
                    acpow *= x;
                }
                x *= x;
                n /= 2;
            }
            acpow = acpow * x;
        }
        return acpow;
    }

    /**
     *
     * @param n
     * @param y
     * @return
     */
    double lefttoright(int n, double y) { // caculate n-th power of base y. n should be greater than 0
        if (n < 0) {
            throw new IllegalArgumentException("n should be greater than 0.");
        }
        double pow = y;
        double power = 1;
        while (n != 0) {
            pow = y;
            int i = 2;
            while (i <= n) {
                pow *= pow;
                i *= 2;
            }
            n = n - i / 2;
            power = pow * power;
        }
        return power;
    }

    /**
     * calculate exponential of x with power n
     * @param n is power
     * @param x is base
     * @return x^n;
     */
    public double exponential(int n, double x) { 
        if (n == -1) {
            return 1 / x;
        } else if (n == 1) {
            return x;
        } else if (n == 0) {
            return 1;
        } else if (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
                return exponential(n, x) * exponential(n, x);
            } else {
                n = (n - 1) / 2;
                return exponential(n, x) * exponential(n, x) * x;
            }
        } else {
            if (n % 2 == 0) {
                n /= 2;
                return exponential(n, x) * exponential(n, x);
            } else {
                n = (n + 1) / 2;
                return exponential(n, x) * exponential(n, x) / x;
            }
        }
    }

    /**
     *
     * @param a
     * @return
     */
    double binaryconverting(double a) { //converting a decimal integer to binary integer 
        int c = (int) a, j = -1, i = 0;
        double d = abs(a - c), e = 0, b = 0;
        while (c != 0) {
            if (c % 2 == 1) {
                b = b + exponential(i, 10);
            }
            c /= 2;
            ++i;
        }
        if (d == 0) {
            return b + e;
        } else {
            while (d != 1) {
                if (d * 2 >= 1) {
                    e = e + exponential(j, 10);
                    if (d * 2 > 1) {
                        d = d * 2 - 1;
                    } else {
                        d *= 2;
                    }
                } else {
                    d *= 2;
                }
                --j;
            }
            return b + e;
        }
    }

    /**
     * calculating the approximation of a decimal number with a limit of 11 number after the dot. 
     * @param number
     * @return
     */
    public double approximation(double number) { 
        double x = abs(number);
        int a = (int) x;
        double b = x - a;
        int i = 0;
        while ((int) b == 0 && i <= 8) {
            b *= 10;
            ++i;
        }
        int c = (int) b;
        b = b - c;
        b *= 10;
        int d = (int) b;
        if (number >= 0) {
            if (d >= 5) {
                return a + (c + 1) / ((exponential(i, 10)));
            } else {
                return a + c / ((exponential(i, 10)));
            }
        } else {
            if (d >= 5) {
                return -(a + (c + 1) / ((exponential(i, 10))));
            } else {
                return -(a + c / ((exponential(i, 10))));
            }
        }
    }

    /**
     *
     * @param a
     * @return
     */
    int approximationToInteger(double a) {
        int tempInt = (int) a;
        double tempDecimal = a - tempInt;
        if (tempDecimal < 0.5) {
            return tempInt;
        } else {
            return tempInt + 1;
        }
    }

    /**
     *
     * @param x
     * @param n
     * @param array
     * @return
     */
    double derivation(double x, int n, double[] array) { //caculate derivative of a polynomial with n = 0,... array.length-1; n initial = array.length-1
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return array[1];
        } else {
            return derivation(x, n - 1, array) + array[n] * n * exponential(n - 1, x);
        }
    }

    /**
     *
     * @param a
     * @return
     */
    double babilonian(double a) { // finding square of the given number
        if (a < 0) {
            throw new IllegalArgumentException("Negative number doesn't have square.");
        } else {
            double x = 1;
            double error = 0.0001;
            while (abs(x - a / x) > error) {
                x = (x + a / x) / 2;
            }
            return x;
        }
    }

    /**
     *
     * @param a
     * @return
     */
    boolean prime(float a) { //checking whether the given number is a prime
        if (a % 2 == 0 || a % 3 == 0) {
            return false;
        }
        int i = 5;
        while (i <= babilonian(a)) {
            if (a % i == 0) {
                return false;
            }
            i = i + 6;
        }
        int j = 7;
        while (j < babilonian(a)) {
            if (a % j == 0) {
                return false;
            }
            j = j + 6;
        }
        return true;
    }

    /**
     *
     * @param number
     * @param nth
     * @return
     */
    public double nthRoot(double number, int nth) {
        // number >= 0; nth >=0
        if (number < 0 || nth < 0) {
            throw new IllegalArgumentException("Number must be larger than 0");
        } else {
            double[] polynomial = new double[nth + 1];
            Array array = new Array();
            array.generate0(polynomial);
            polynomial[nth] = 1.0;
            polynomial[0] = number;
            while (abs(polynomial[nth] * exponential(nth, number) - polynomial[0]) > 0.00000001) {
                number = number - (polynomial[nth] * exponential(nth, number) - polynomial[0]) / derivation(number, nth, polynomial);
            }
            return number;
        }
    }

    /**
     *
     * @param number1
     * @param number2
     * @return
     */
    String sumLargeInteger(String number1, String number2) {
        //add 2 numbers having equal number of digits
        DataExchanging converting = new DataExchanging();
        if(number1.length()<10&&number2.length()<10){
            int result = converting.convertStringToInt(number1)+converting.convertStringToInt(number2);
            return converting.convertIntToString(result);
        }
        else{
            String temp1, temp2, temp3, temp4, high, low, numberOfZeroDigit = "";
            temp1 = number1.substring(0, number1.length() / 2);
            temp2 = number1.substring(number1.length() / 2, number1.length());
            if (temp1.length() < temp2.length()) {
                temp1 = "0" + temp1;
            }
            temp3 = number2.substring(0, number2.length() / 2);
            temp4 = number2.substring(number2.length() / 2, number2.length());
            if (temp3.length() < temp4.length()) {
                temp3 = "0" + temp3;
            }
            high = sumLargeInteger(temp1, temp3);
            low = sumLargeInteger(temp2, temp4);
            if(low.length() == temp1.length()){
                return high+low;
            }
            else{
                int temp = converting.convertStringToInt(high.substring(high.length()-1, high.length()));
                ++temp;
                high = high.substring(0, high.length()-1) + converting.convertIntToString(temp);
                return high + low.substring(1, low.length());
            }
        }
    }
    
    /**
     * add 2 numbers 
     * @return 
     */
    public String sumLargeIntegerPro(String number1, String number2){
        try{
        DataExchanging converting = new DataExchanging();
        String longNumber, shortNumber, result = "", subLongNumber;
        if(number1.length()>number2.length()){
            longNumber = number1;
            shortNumber = number2; 
        }
        else{
            longNumber = number2;
            shortNumber = number1;
        }
        subLongNumber = longNumber.substring(longNumber.length()-shortNumber.length(), longNumber.length());
        result = sumLargeInteger(subLongNumber, shortNumber);
        if(shortNumber.length()==longNumber.length()){
            return result;
        }
        else{
        if(result.length()==shortNumber.length()){
            return longNumber.substring(0, longNumber.length()-shortNumber.length())+result;
        }
        else{
            int temp = converting.convertStringToInt(longNumber.substring(longNumber.length()-shortNumber.length()-1, longNumber.length()-shortNumber.length()));
            ++temp;
            return longNumber.substring(0, longNumber.length()-shortNumber.length()-1)+converting.convertIntToString(temp)+result.substring(1, result.length());
        }
    }
    }
        catch(Exception e){
            System.out.println("We cant add these numbers.");
            return null;
        }
    }
            
    
    /**
     * multiply 2 number having equal number of digits. Number1 and number2 have equal number of digits
     * @return - Product of number1 and number2
     *         - null if number1 and number2 doesn't have the same number of digits
     */
    public String multLargeInteger(String number1, String number2) {
        if(number1.length() == number2.length()){
        DataExchanging converting = new DataExchanging();
        String result;
        if (number1.length() < 5 && number2.length() < 5) {
            int resultInt = converting.convertStringToInt(number2) * converting.convertStringToInt(number1);
            return converting.convertIntToString(resultInt);
        } else {
            String temp1, temp2, temp3, temp4,high, median1, median2, low, temp = "";
            temp1 = number1.substring(0, number1.length() / 2);
            temp2 = number1.substring(number1.length() / 2, number1.length());
            if (temp1.length() < temp2.length()) {
                temp1 = "0" + temp1;
            }
            temp3 = number2.substring(0, number2.length() / 2);
            temp4 = number2.substring(number2.length() / 2, number2.length());
            if (temp3.length() < temp4.length()) {
                temp3 = "0" + temp3;
            }
            high = multLargeInteger(temp1, temp3);
            median1 = multLargeInteger(temp1, temp4);
            median2 = multLargeInteger(temp2, temp3);
            low = multLargeInteger(temp2, temp4);
            for (int i = 0; i < temp2.length(); i++) {
                temp += "0";
            }
            result = sumLargeIntegerPro(sumLargeInteger(median1, median2)+temp,low);
            for (int i = temp2.length(); i < number1.length(); i++) {
                temp +="0";
            }
            result = sumLargeIntegerPro(high+temp, result);
            return result;
        }
    }
        else{
            System.out.println("We cant multiply 2 numbers having different digits.");
            return null;
        }
}
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
    public void equatSolver(double[][] matrix, double[] rightHand) {
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
                System.out.println("x[" + i + "] = " + calculator.abs(zeroOfEquations[i]) + ". Err = " + (zeroOfEquations[i] - calculator.abs(zeroOfEquations[i])));
            }
        } else {
            System.out.println("Khong giai duoc phuong trinh bang gauss.");
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
    public void equatSolvers(double[][] matrix, double[] rightHand) {
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
                    zeroOfX[i] = rightHand[i] / matrix[i][j];
                    System.out.println("X" + i + " = " + zeroOfX[i]);
                }
            }
        }

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
}
