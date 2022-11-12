package subsets;

import java.util.List;
import java.util.ArrayList;

public class Solution_naive {
    public static List<List<Integer>> subsets(int[] nums){
        List<Integer> child = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>(child);
        result.add(list);
        utils(result, child, 0, nums);
        return result;
    }

    public static void utils(List<List<Integer>> result, List<Integer> child, int index, int[] nums){
        if(index < nums.length){
            child.add(nums[index]);
            List<Integer> list = new ArrayList<>(child);
            result.add(list);
            utils(result, child, index+1, nums);
            child.remove(child.size()-1);
            utils(result, child, index+1, nums);
        }
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        List<List<Integer>> result = subsets(nums);
        System.out.println(result);
    }
}
