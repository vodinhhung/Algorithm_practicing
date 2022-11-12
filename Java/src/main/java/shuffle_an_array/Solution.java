package shuffle_an_array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Solution {
    int[] nums;
    List<Integer> original;

    public Solution(int[] nums) {
        this.nums = nums;
        original = new ArrayList<>();
        for(int n: nums)
            original.add(n);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        int[] reset = new int[nums.length];
        for(int i=0; i<reset.length; i++){
            reset[i] = original.get(i);
        }
        return reset;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shu = new int[original.size()];
        int index = 0;
        List<Integer> shuffle = new ArrayList<>(original);
        Random rand = new Random();

        for(int i=0; i<original.size(); i++){
            int random = rand.nextInt(shuffle.size());
            shu[index] = shuffle.get(random);
            index++;
            shuffle.remove(random);
        }
        return shu;
    }
}
