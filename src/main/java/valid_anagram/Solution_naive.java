package valid_anagram;

import java.util.Arrays;

public class Solution_naive {
    public static boolean isAnagram(String s, String t) {
        char[] chS = s.toCharArray();
        char[] chT = t.toCharArray();

        if(t.length() != s.length()) return false;
        if(s.length() == 0 && t.length() == 0) return true;

        Arrays.sort(chS);
        Arrays.sort(chT);

        int i = 0;
        int j = 0;
        while(i<chT.length){
            if(chT[i] != chS[j]){
                i++;
                j=0;
            }
            else {
                if(j == chS.length-1)
                    return true;
                i++;
                j++;
            }
        }

        return false;
    }

    public static void main(String[] args){
        String s = "a";
        String t = "ab";
        boolean isAnagram = isAnagram(s, t);

        System.out.println(isAnagram);
    }
}
