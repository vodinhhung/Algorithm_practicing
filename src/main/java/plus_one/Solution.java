package plus_one;

public class Solution {
    public static int[] plusOne(int[] digits) {
        int i=digits.length-1;
        int rem = 0;
        digits[i] = digits[i]+1;

        if(digits[i]<10){
            return digits;
        } else{
            rem = 1;
            digits[i] = 0;
            i--;

            while(i>=0){
                digits[i] = digits[i]+rem;
                if(digits[i]==10){
                    rem=1;
                    digits[i]=0;
                    i--;
                } else {
                    return digits;
                }
            }

            int[] result = new int[digits.length+1];
            result[0] = 1;

            return result;
        }
    }

    public static void main(String[] args){
        int[] digits = {9,1,9,9};
        int[] result = plusOne(digits);

        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
}
