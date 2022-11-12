package replace_substring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int balancedString(String s) {
        char[] ch = s.toCharArray();
        int length = ch.length;
        if(length == 0) return 0;
        if(length%4 != 0) return -1;
        Map<Character, Integer> store = new HashMap<>();

        for(int i=0; i<length; i++){
            if(!store.containsKey(ch[i]))
                store.put(ch[i], 1);
            else
                store.put(ch[i], store.get(ch[i])+1);
        }

        Map<Character, Integer> modifi = new HashMap<>();
        for(char child: store.keySet()){
            if(store.get(child) > length/4)
                modifi.put(child, store.get(child)-length/4);
        }

        int result = 0;
        for(int i=0; i<length; i++){
            if(!modifi.containsKey(ch[i])) continue;
            int minLength = 1;
            Map<Character, Integer> xx = new HashMap<>(modifi);
            xx.put(ch[i], xx.get(ch[i])-1);
            for(int j=i+1; j<length; j++){
                minLength++;
                if(xx.containsKey(ch[j])) {
                    xx.put(ch[j], xx.get(ch[j]) - 1);
                    if (xx.get(ch[j]) == 0) xx.remove(ch[j]);
                    if (xx.size() == 0) break;
                }
            }
            if(result != 0)
                result = result>minLength? minLength:result;
            else
                result = minLength;
        }

        return result;
    }

    public static void main(String[] args){
        String s = "QQWE";
        System.out.println(balancedString(s));
    }
}
