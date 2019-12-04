package four_sum;

import java.util.HashMap;
import java.util.Map;

public class Solution_naive {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        Map<Integer, Integer> store = new HashMap<>();
        for(int i=0; i<A.length; i++)
            for(int j=0; j<B.length; j++)
                for(int k=0; k<C.length; k++){
                    int x = A[i]+B[j]+C[k];
                    store.put(x, store.getOrDefault(x, 0)+1);
                }
        for(int i=0; i<D.length; i++){
            if(store.containsKey(-D[i]) && store.get(-D[i])!=0){
                result += store.get(-D[i]);
            }
        }

        return result;
    }
}
