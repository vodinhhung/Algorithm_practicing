package sqrt_of_x;

public class Solution {
    public static int mySqrt(int x) {
        if(x==0) return 0;
        if(x==1) return 1;
        return mySqrt(x, 0, x);
    }

    public static int mySqrt(int x, int start, int end){
        if(start >= end-1) return start;
        int middle = (start+end)/2;
        if(middle == x/middle) // Avoid stack overflow
            return middle;
        else if(middle > x/middle)
            return mySqrt(x, start, middle);
        else
            return mySqrt(x, middle, end);
    }

    public static void main(String[] args){
        int x = 8;
        int result = mySqrt(x);

        System.out.println(result);
    }
}
