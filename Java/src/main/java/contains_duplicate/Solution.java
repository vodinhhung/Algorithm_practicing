package contains_duplicate;

public class Solution {
    public static boolean containsDuplicate(int[] nums) {
        for(int i=1; i<nums.length; i++){
            nums[i] = nums[i] ^ nums[i-1];
        }
        if(nums[nums.length-1] != 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        int[] nums = {1,2,2,4};
        boolean isDup = containsDuplicate(nums);
        System.out.println(isDup);
    }
}
