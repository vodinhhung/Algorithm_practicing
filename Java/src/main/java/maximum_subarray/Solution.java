package maximum_subarray;

public class Solution {
    public static int maxSubArray(int[] nums) {
        int max_end_here = 0;
        int max_all = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            max_end_here += nums[i];
            if(max_all < max_end_here) max_all = max_end_here;
            if(max_end_here < 0) max_end_here = 0;
        }

        return max_all;
    }

    public static void main(String[] args){
        int[] nums = {-1, -10, 4, -43};
        int max = maxSubArray(nums);

        System.out.println(max);
    }
}
