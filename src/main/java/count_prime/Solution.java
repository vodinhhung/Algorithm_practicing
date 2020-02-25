package count_prime;

import java.util.*;

public class Solution {
    public Map<Integer, Boolean> renderPrimeList(int n) {
        Map<Integer, Boolean> primeList = new HashMap<>();
        Map<Integer, Boolean> nonPrimeList = new HashMap<>();

        int square = (int) Math.sqrt(n);
        for(int i=2; i<=square; i++){
            if(!nonPrimeList.containsKey(i)){
                int j = i;
                while(i*j<n){
                    nonPrimeList.put(i*j, true);
                    j++;
                }
            }
        }

        for(int i=2; i<n; i++){
            if(!nonPrimeList.containsKey(i)){
                primeList.put(i, true);
            }
        }

        return primeList;
    }

    public int countPrimes(int n) {
        Map<Integer, Boolean> primeList = renderPrimeList(n);
        return primeList.keySet().size();
    }
}
