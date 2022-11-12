package subsets;

import java.util.ArrayList;
import java.util.List;

/*
Leetcode 78
 */
public class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        util(nums, 0, r, ret);
        return ret;
    }

    public static void util(int[] nums, int index, List<Integer> r, List<List<Integer>> ret) {
        if(index == nums.length) {
            ret.add(new ArrayList<Integer>(r));
            return;
        }
        util(nums, index+1, r, ret);
        r.add(nums[index]);
        util(nums, index+1, r, ret);
        r.remove(r.size()-1);
        return;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3};
        List<List<Integer>> result = subsets(nums);
        System.out.println(result);
    }
}
