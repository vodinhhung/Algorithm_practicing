package unique_paths;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    static Map<List<Integer>, Integer> list = new HashMap<>();

    public static int uniquePaths(int m, int n) {
        List<Integer> child = new ArrayList<>();
        child.add(m);
        child.add(n);
        if(list.containsKey(child)) return list.get(child);

        if(m==1 && n==1) list.put(child, 1);
        if(m!=1 && n==1) list.put(child, uniquePaths(m-1, n));
        if(m==1 && n!=1) list.put(child, uniquePaths(m, n-1));
        if(m!=1 && n!=1) list.put(child, uniquePaths(m-1, n)+uniquePaths(m, n-1));

        return list.get(child);
    }

    public static void main(String[] args){
        int m=100;
        int n=100;
        int result = uniquePaths(m,n);

        System.out.println(result);
    }
}
