package k_largest_element;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums.length;
        for(int i=0; i<n-k+1; i++){
            heap.add(nums[i]);
        }

        for(int i=n-k+1; i<n; i++){
            heap.add(nums[i]);
            heap.poll();
        }

        return heap.poll();
    }

    public static void main(String[] args){
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;

        int result = findKthLargest(nums, k);
        System.out.print(result);
    }
}
