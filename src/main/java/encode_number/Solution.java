package encode_number;

public class Solution {
    public static String encode(int num) {
        if(num==0) return "";
        int n = (int) (Math.log(num+1)/Math.log(2));
        n = (int) Math.pow(2, (double) n);
        int fa = num + 1 - n;

        String code = Integer.toString(fa, 2);
        while(code.length() == n){
            code = "0" + code;
        }
        return code;
    }

    public static void main(String[] args){
        int num = 3;
        System.out.print(encode(num));
    }
}
