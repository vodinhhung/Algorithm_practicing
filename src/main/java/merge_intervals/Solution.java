package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][0];
        if(intervals.length == 1) return intervals;
        List<int[]> result = new ArrayList<>();

        Comparator<int[]> arrayCom = new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] - t2[0];
            }
        };
        Arrays.sort(intervals, arrayCom);

        int min = intervals[0][0];
        int max = intervals[0][1];
        int i = 0;

        while(i<intervals.length-1){
            if(max < intervals[i+1][0]){
                int[] child = new int[]{min, max};
                result.add(child);
                min = intervals[i+1][0];
                max = intervals[i+1][1];
                i++;
                if(i==intervals.length-1){
                    int[] child2 = new int[]{min, max};
                    result.add(child2);
                    break;
                }
            } else{
                if(i==intervals.length-2){
                    max = max>=intervals[i+1][1]? max:intervals[i+1][1];
                    int[] child = new int[]{min, max};
                    result.add(child);
                    break;
                } else {
                    max = max>=intervals[i+1][1]? max:intervals[i+1][1];
                    i++;
                }
            }
        }

        int[][] re = new int[result.size()][2];
        for(int k=0; k<result.size(); k++){
            re[k] = result.get(k);
        }

        return re;
    }

    public static void main(String[] args){
//        int[][] intervasl = new int[][]{{1,4},{4,5},{6,8},{7,13}};
        int[][] intervasl = new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] result = merge(intervasl);

        for(int i=0; i<result.length; i++){
            System.out.println(result[i][0] +":"+ result[i][1]);
        }
    }
}
