package top_k_frequent_elements;

import java.util.List;

public class Main {
    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        List<Integer> result = solution1.topKFrequent(nums, k);
        System.out.println(result);
    }
}
