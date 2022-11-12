package numbers_of_1_bit;

/*
LeetCode 191
 */
public class Solution {
    public static int hammingWeight(int n) {
        int sum = 0;
        while(n>0){
            sum += n%10;
            n = n/10;
        }
        return sum;
    }

    public static void main(String[] args){
        int n = 00000000000000000000000000001011;
        System.out.println(n);
        int result = hammingWeight(n);

        System.out.println(result);
    }
}
