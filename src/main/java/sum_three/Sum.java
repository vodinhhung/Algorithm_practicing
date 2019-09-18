package sum_three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //System.out.println(list);
        Arrays.sort(nums);
//        for(int i=0; i<nums.length; i++) {
//            System.out.println(nums[i]);
//        }

        for(int i=0; i<nums.length; i++) {
            int j = 0;
            int k = nums.length-1;
            while(j<k) {
                if(j==i) j++;
                if(k==i) k--;
                if(j>=k) {
                    break;
                }

                if((nums[i] +nums[j] + nums[k]) == 0){
                    List<Integer> tiny = new ArrayList<>();
                    tiny.add(nums[i]);
                    tiny.add(nums[j]);
                    tiny.add(nums[k]);
                    Collections.sort(tiny);
                    if(!list.contains(tiny)) {
                        list.add(tiny);
                    }
                    //System.out.println(list);
                    j++;
                    k--;
                } else {
                    if((nums[i] +nums[j] + nums[k]) > 0) {
                        k--;
                    }
                    if((nums[i] +nums[j] + nums[k]) < 0) {
                        j++;
                    }
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,0};
        System.out.println(threeSum(nums));
    }
}
