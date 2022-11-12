package insert_position;

public class Solution {
    public static int searchInsert(int[] nums, int target) {
        int i=0;
        for(i=0; i<nums.length; i++){
            if(nums[i] >= target){
                return i;
            }
        }

        if(i == nums.length-1) {
            return nums.length;
        } else {
            return 0;
        }
    }

    public static void main(String[] args){
        int[] nums = {1,3,5,6};
        int tar = 7;

        int re = searchInsert(nums, tar);
        System.out.println(re);
    }
}
