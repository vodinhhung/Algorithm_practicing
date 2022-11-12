package product_of_array_except_sell;

/*
Leetcode 238
 */
public class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for(int i=1; i<nums.length; i++){
            result[0] = result[0]*nums[i];
        }

        if(result[0] != 0){
            for(int i=1; i<nums.length; i++){
                result[i] = result[0]/nums[i] * nums[0];
            }
        } else {
            for(int i=1; i<nums.length; i++){
                if(nums[i] != 0) result[i] = 0;
                else{
                    result[i]=1;
                    int j=0;
                    while(j<nums.length){
                        if(j!=i){
                            result[i] = result[i] * nums[j];
                        }
                        j++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = {9, 0, -2};
        int[] result = productExceptSelf(nums);

        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
}
