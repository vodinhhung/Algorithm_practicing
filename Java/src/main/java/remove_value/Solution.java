package remove_value;

public class Solution {
    public static int removeElement(int[] nums, int val) {
        int i=0;
        int j=nums.length - 1;
        int result = 0;

        for(int k=0; k<nums.length; k++){
            if(nums[k] != val){
                result++;
            }
        }

        while(j>i){
            if(nums[j] == val){
                j--;
            } else {
                if(nums[i] == val){
                    nums[i] = nums[j];
                    i++;
                    j--;
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[] nums= {3,2,2,3};
        int val = 3;

        int length = removeElement(nums, val);
        for(int i=0; i<length; i++){
            System.out.println(nums[i]);
        }
    }
}
