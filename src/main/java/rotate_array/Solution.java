package rotate_array;

public class Solution {
    public static void rotate(int[] nums, int k) {
        if(nums.length==0) return;
        k = k%(nums.length);
        int[] result = new int[nums.length];
        for(int i=k; i<result.length; i++){
            result[i] = nums[i-k];
        }
        for(int i=0; i<k; i++){
            result[i] = nums[nums.length-k+i];
        }
        for(int i=0; i<nums.length; i++){
            nums[i] = result[i];
        }
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8};
        rotate(nums, 14422);

        for(int i=0; i<nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}