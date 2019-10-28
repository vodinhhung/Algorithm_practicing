package max_length_concentration;

import java.util.*;

public class Solution {
    public static int maxLength(List<String> arr) {
        Collections.sort(arr, Comparator.comparing(String::length));
        System.out.println(arr);
        int[] count = new int[26];
        String[] store = new String[arr.size()];
        int max = 0;
        for(int i=arr.size()-1; i>=0; i--){
            char[] chars = arr.get(i).toCharArray();
            for(int k=0; k<chars.length; k++){
                count[chars[k]-'a']++;
            }
            store[i] = arr.get(i);

            for(int j=i-1; j>=0; j--){
                char[] child = arr.get(j).toCharArray();
                int k=0;
                for(k=0; k<child.length; k++){
                    if(count[child[k]-'a']==1) break;
                }
                if(k==child.length){
                    for(char ch: child){
                        count[ch-'a']++;
                    }
                    store[i] += arr.get(j);
                }
            }
            max = max>store[i].length()? max:store[i].length();
        }
        return max;
    }

    public static void main(String []args){
        List<String> arr = new ArrayList<>(
                Arrays.asList("a","c","br","d"));

        System.out.println(maxLength(arr));
    }
}
