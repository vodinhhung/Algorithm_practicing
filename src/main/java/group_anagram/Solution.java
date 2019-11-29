package group_anagram;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> store = new HashMap<>();
        for(String str: strs){
            String s = sortChar(str);
//            List<String> child;
//            if(store.containsKey(s)) child = store.get(s);
//            else child = new ArrayList<>();

            List<String> child = store.getOrDefault(s, new ArrayList<>());
            child.add(str);
            store.put(s, child);
        }

        List<List<String>> result = new ArrayList<>();
        for(String key: store.keySet())
            result.add(store.get(key));

        return result;
    }

    private String sortChar(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
