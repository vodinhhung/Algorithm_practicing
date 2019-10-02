package majority_element;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    static Map<Integer, Integer> count = new HashMap<>();

    public static int majorityElement(int[] nums) {
        int length = nums.length;
        for(int i=0; i<length; i++){
            if(!count.containsKey(nums[i])) {
                count.put(nums[i], 1);
            }
            else{
                count.put(nums[i], count.get(nums[i])+1);
            }
            if(count.get(nums[i]) > length/2) return nums[i];
        }
        return 0;
    }

    public static void main(String[] args){
        int[] nums = {1};
        int result = majorityElement(nums);

        System.out.println(result);
    }
}
