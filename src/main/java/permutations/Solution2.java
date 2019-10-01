package permutations;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    static List<List<Integer>> ans = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> child = new LinkedList<>();
        makeAll(0, nums, child);

        return ans;
    }

    private static void makeAll(int i, int[] nums, List<Integer> s)
    {
        if(i == nums.length)
        {
            ans.add(s);
        }
        else
        {
            LinkedList<Integer> temp;

            for(int g = 0; g < nums.length; g++)
            {
                temp = new LinkedList<>();
                temp.addAll(s);

                //distinct permutations only
                if(temp.contains(nums[g]))
                {
                    continue;
                }

                temp.add(nums[g]);
                makeAll(i + 1, nums, temp);
            }
        }
    }

    public static void main(String[] args){
        int[] nums =  {1, 2, 3};
        List<List<Integer>> result = permute(nums);

        System.out.println(result);
    }
}
