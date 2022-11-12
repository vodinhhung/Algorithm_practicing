package permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> child  = new ArrayList<>();
        if(nums.length != 0) permute(nums, 0, result, child);
        return result;
    }

    public static void permute(int[] nums, int index, List<List<Integer>> result, List<Integer> child){
        if(index < nums.length){
            for(int i=0; i<nums.length; i++){
                if(!child.contains(nums[i])){
                    List<Integer> temp = new ArrayList<>();
                    temp.addAll(child);
                    temp.add(nums[i]);
                    permute(nums, index+1, result, temp);
                }
            }
        } else{
            result.add(child);
        }
    }

    public static void main(String[] args){
        int[] nums =  {1, 2, 3};
        List<List<Integer>> result = permute(nums);

        System.out.println(result);
    }
}
