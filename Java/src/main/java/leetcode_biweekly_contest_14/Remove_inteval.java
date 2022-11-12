package leetcode_biweekly_contest_14;

import java.util.*;

public class Remove_inteval {
    public static List<Integer> toList(int[] child){
        List<Integer> resukt = new ArrayList<>();
        for(int i: child)
            resukt.add(i);
        return resukt;
    }

    public static List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> result = new ArrayList<>();
        int a = toBeRemoved[0];
        int b = toBeRemoved[1];

        for(int[] child: intervals){
            if(child[1]<a){
                List<Integer> list = toList(child);
                result.add(list);
                continue;
            }
            if(child[0] >= a){
                if(child[0] >= b){
                    List<Integer> list = toList(child);
                    result.add(list);
                    continue;
                }
                if(child[0] < b && child[1] > b){
                    child[0] = b;
                    List<Integer> list = toList(child);
                    result.add(list);
                    continue;
                }
            }

            if(child[0] < a && a < child[1]){
                if(child[1] <= b){
                    child[1] = a;
                    List<Integer> list = toList(child);
                    result.add(list);
                    continue;
                }
                if (child[1] > b) {
                    int[] y = new int[2];
                    y[0] = child[0];
                    y[1] = a;
                    List<Integer> list = toList(y);
                    result.add(list);

                    int[] x = new int[2];
                    x[0] = b;
                    x[1] = child[1];
                    List<Integer> list1 = toList(x);
                    result.add(list1);
                    continue;
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[][] n = {
                {0,100},
        };

        int[] re = {0, 50};
        System.out.print(removeInterval(n, re));
    }
}
