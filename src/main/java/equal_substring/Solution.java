package equal_substring;

import java.util.Arrays;

public class Solution {
    public static int equalSubstring(String s, String t, int maxCost) {
        if(s.length() == 0) return 0;
        int[] cost = new int[s.length()];
        cost[0] = Math.abs(s.charAt(0)-t.charAt(0));
        for(int i=1; i<s.length(); i++){
            cost[i] = Math.abs(s.charAt(i)-t.charAt(i));
        }

        Arrays.sort(cost);
        if(maxCost < cost[0]) return 0;
        for(int i=1; i<cost.length; i++){
            cost[i] += cost[i-1];
            if(cost[i] > maxCost) return i;
        }

        return cost.length;
    }

    public static void main(String[] args){
        String s = "krrgw";
        String t = "zjxss";
        for(int i=0; i<s.length(); i++){
            System.out.println((int)s.charAt(i) +" : "+(int)t.charAt(i));
        }

        int result = equalSubstring(s, t, 19);
        System.out.println(result);
    }
}
