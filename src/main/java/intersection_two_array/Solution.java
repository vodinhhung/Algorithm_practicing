package intersection_two_array;

import java.util.*;

public class Solution {
    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0) return new int[0];

        Map<Integer, Integer> counting = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<nums1.length; i++){
            if(counting.containsKey(nums1[i])){
                int re = counting.get(nums1[i]);
                counting.put(nums1[i], ++re);
            } else{
                counting.put(nums1[i], 1);
            }
        }

        for(int i=0; i<nums2.length; i++){
            if(counting.containsKey(nums2[i]) && counting.get(nums2[i])!=0){
                result.add(nums2[i]);
                int re = counting.get(nums2[i]);
                counting.put(nums2[i], --re);
            }
        }

        int[] re = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            re[i] = result.get(i);
        }

        return re;
    }

    public static void main(String[] args){
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        int[] result = intersect(nums1, nums2);

        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
}
