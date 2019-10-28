package amazon_intern_apply;

import java.util.*;
public class Question1 {

    public static List<String> retrieveMostFrequentlyUsedWords(String literatureText,
                                                 List<String> wordsToExclude)
    {
        // WRITE YOUR CODE HERE
        Map<String, Integer> count = new HashMap<>();
        String[] splits = literatureText.split("\\W");
        for (int i =0; i < splits.length; i++){
            String str = splits[i].replaceAll("[\\W]", "").toLowerCase();
            if (wordsToExclude.contains(str) || str.equals("")) continue;
            count.put(str, count.getOrDefault(str, 0) + 1);
        }

        int max = 0;
        List<String> results = new ArrayList<>();
        for(String key: count.keySet()){
            max = max>count.get(key)? max:count.get(key);
        }

        for(String key: count.keySet()){
            if(max == count.get(key)){
                results.add(key);
            }
        }
        return results;
    }
    // METHOD SIGNATURE ENDS

    public static boolean isCharacter(char a){
        return ((a>96 && a<123) || (a>64 && a<91));
    }

    public static void main(String[] args){
        String s = "Rose is a flower red rose are flower";
        List<String> words = new ArrayList<>();
        words.add("is");
        words.add("are");
        words.add("a");

        System.out.println(retrieveMostFrequentlyUsedWords(s, words));
    }
}
