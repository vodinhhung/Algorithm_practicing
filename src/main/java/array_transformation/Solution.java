package array_transformation;

import java.util.*;
import java.util.ArrayList;

public class Solution {
    public static List<Integer> transformArray(int[] a) {
        int ope = 0;

        do{
            ope = 0;
            int[] arr = new int[a.length];
            arr[0] = a[0];
            arr[a.length-1] = a[a.length-1];
            for(int i=1; i<a.length-1; i++){
                if(a[i-1] < a[i] && a[i] > a[i+1]) {
                    arr[i] = a[i]-1;
                    ope++;
                }
                if(a[i-1] > a[i] && a[i] < a[i+1]) {
                    arr[i] = a[i]+1;
                    ope++;
                }
            }
            if(ope != 0) a = arr;
        }while(ope != 0);

        List<Integer> result = new ArrayList<>();
        for(int i=0; i<a.length; i++)
            result.add(a[i]);

        return result;
    }

    public static void main(String[] args){
        int[] nums = {6,2,3,4};
        System.out.println(transformArray(nums));
    }
}
