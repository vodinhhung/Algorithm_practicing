package sort_color;

public class Solution {
    public static void sortColors(int[] nums) {
        if(nums.length == 0) return;
        int i=0;
        int start = -1;
        int end = nums.length;

        for(i=0; i<end; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[++start];
                nums[start] = temp;
            }else if(nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[--end];
                nums[end] = temp;
                i--;
            }
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,2,2,2,0,0,0,1,1};
        sortColors(nums);

        for(int i=0; i<nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
