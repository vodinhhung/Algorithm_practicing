package top_k_frequent_elements;

import java.util.*;

public class Solution1 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int n: nums)
            count.put(n, count.getOrDefault(n, 0)+1);

        Map<Integer, List<Integer>> frequency = new HashMap<>();
        for(int n: count.keySet()){
            if(frequency.containsKey(count.get(n))){
                int fre = count.get(n);
                List<Integer> child = frequency.get(fre);
                child.add(n);
                frequency.put(fre, child);
            } else {
                int fre = count.get(n);
                List<Integer> child = new ArrayList<>();
                child.add(n);
                frequency.put(fre, child);
            }
        }

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int n: frequency.keySet()){
            pQueue.add(n);
        }

        List<Integer> result = new ArrayList<>();
        while(result.size() < k){
            int fre = pQueue.poll();
            result.addAll(frequency.get(fre));
        }

        return result;
    }
}
