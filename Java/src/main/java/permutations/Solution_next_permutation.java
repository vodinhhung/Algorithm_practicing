package permutations;

import java.util.Arrays;

public class Solution_next_permutation {
    public static void nextPermutation(int[] nums) {
        if(nums==null || nums.length==0) return;
        int i = nums.length-1;
        for(i=nums.length-1; i>=1; i--){
            if(nums[i] > nums[i-1]){
                int noSwap = findMinOfBigger(nums, i-1);
                int temp = nums[i-1];
                nums[i-1] = nums[noSwap];
                nums[noSwap] = temp;
                break;
            }
        }
        Arrays.sort(nums, i, nums.length);
    }

    public static int findMinOfBigger(int[] nums, int index){
        if(index == nums.length-1) return index;
        for(int i=index+1; i<nums.length; i++){
            if(nums[index] >= nums[i])
                return i-1;
        }
        return nums.length-1;
    }

    public static void main(String[] args){
        int[] nums = {1,3,2};
        nextPermutation(nums);

        for(int i=0; i<nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
