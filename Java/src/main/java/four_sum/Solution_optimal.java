package four_sum;

import java.util.HashMap;
import java.util.Map;

public class Solution_optimal {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        int[] st1 = new int[n*n];
        int[] st2 = new int[n*n];
        int index = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                st1[index] = A[i]+B[j];
                st2[index] = C[i]+D[j];
                index++;
            }
        }

        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n*n; i++)
            map.put(st1[i], map.getOrDefault(st1[i], 0)+1);
        for(int i=0; i<n*n; i++){
            if(map.containsKey(-st2[i]))
                result += map.get(-st2[i]);
        }

        return result;
    }
}
