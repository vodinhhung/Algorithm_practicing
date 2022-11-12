package pow;

public class Solution {
//    public static double myPow(double x, int n) {
//        if(x==0 || x==1) return x;
//        if(n==0) return 0.0;
//        if(n==1) return x;
//        if(n==-1) return 1/x;
//
//        if(n>=2)
//            return PositivePow(x, n);
//        else
//            return 1/PositivePow(x,-n);
//    }
//
//    public static double PositivePow(double x, int n){
//        if(n==0) return 1.0;
//        if(n==1) return x;
//        double result = x;
//        int pow = 2;
//        while(pow < n) {
//            result = result*result;
//            pow = pow*2;
//        }
//        pow = pow/2;
//
//        result = result*PositivePow(x, n-pow);
//
//        return result;
//    }

    public static double myPow(double x, int n){
        return Math.pow(x, (double) n);
    }

    public static void main(String[] args){
        double result = myPow(0.00001, Integer.MAX_VALUE);

        System.out.println(result);
    }
}
