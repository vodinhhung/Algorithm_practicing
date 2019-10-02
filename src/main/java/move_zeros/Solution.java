package move_zeros;

import java.util.Arrays;

public class Solution {
    public static void swap (int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void moveZeroes(int[] nums) {
        if(nums.length == 0) return;
        int i = 0;
        int j = 0;
        while(j<nums.length && i<nums.length){
            if(nums[i]!= 0){
                i++;
                continue;
            } else if(i>j){
                j=i+1;
                continue;
            }
            if(nums[j] == 0){
                j++;
                continue;
            }
            if(nums[i]==0 && nums[j] !=0 && i<j){
                swap(nums, i, j);
                i++;
                j++;
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {0};
        moveZeroes(nums);

        for(int i=0; i<nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
