package happy_number;

import java.util.ArrayList;
import java.util.List;

/*
Leetcode 202
 */
public class Solution {
    public boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();
        return isHappy(n, list);
    }

    public boolean isHappy(int n, List<Integer> list){
        if(list.contains(n)) return false;
        else list.add(n);
        if(n == 1) return true;
        String s = String.valueOf(n);
        char[] ch = s.toCharArray();
        n=0;
        for(int i=0; i<ch.length; i++){
            n += Character.getNumericValue(ch[i])*Character.getNumericValue(ch[i]);
        }
        return isHappy(n, list);
    }
}
