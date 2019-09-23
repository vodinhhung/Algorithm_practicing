package integer_to_roman;

public class Solution {
    static int[] value = new int[]{1000, 900, 500, 400, 100, 90, 50 ,40, 10, 9, 5, 4, 1};
    static String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String intToRoman(int num) {
        if(num == 0) return "";
        String result = "";

        while(num>0){
            for(int i=0; i<value.length; i++){
                if(num/value[i] != 0){
                    result += roman[i];
                    num -= value[i];
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        int num = 20;
        String s= intToRoman(num);

        System.out.println(s);
    }
}
