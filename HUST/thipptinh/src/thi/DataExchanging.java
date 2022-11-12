/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi;

import thi.MathFormulas;

public class DataExchanging {
   
    public int convertStringToInt(String number) {
        // w(n) = 6*n with n = number.length()
        String[] temp = new String[number.length()];
        String[] tempNumber = new String[10];
        int result = 0;
        tempNumber[0] = "0";
        tempNumber[1] = "1";
        tempNumber[2] = "2";
        tempNumber[3] = "3";
        tempNumber[4] = "4";
        tempNumber[5] = "5";
        tempNumber[6] = "6";
        tempNumber[7] = "7";
        tempNumber[8] = "8";
        tempNumber[9] = "9";
        for (int i = 0; i < temp.length; i++) {
            temp[i] = number.substring(i, i + 1);
            int j;
            if(temp[i].compareToIgnoreCase(tempNumber[5])<0){
                j = 4;
                while(!temp[i].equalsIgnoreCase(tempNumber[j])){
                    --j;
                }
            }
            else{
                j = 5;
                while(!temp[i].equalsIgnoreCase(tempNumber[j])){
                    ++j;
                }
            }
            result = result * 10 + j;
        }
        return result;
    }
    
   
    public String convertIntToString(int number){
        // 11*number.length + 1 
        MathFormulas caculator = new MathFormulas();
        String result = "";
        int temp = number;
        int j = 0;
        while((temp - (int) caculator.exponential(j, 10))>=0){ // number.length +1
            temp = number;
            ++j;
        }
        for (int i = 1; i <= j; i++) { // number.length*10
            int k = 0;
            temp = number;
            while((temp-k)%10!=0){
                temp = number;
                ++k;
            }
            result = k +result;
            number = number/10;
        }
        return result;
    }
}
