package valid_anagram;

public class Solution_optimism {
    public static boolean isAnagram(String s, String t) {
        char[] chS = s.toCharArray();
        char[] chT = t.toCharArray();
        if(chS.length != chT.length) return false;
        if(chS.length==0 && chT.length==0) return true;

        int[] counting = new int[26];
        for(int i=0; i<chS.length; i++){
            counting[chS[i] - 'a']++;
            counting[chT[i] - 'a']--;
        }

        for(int i=0; i<counting.length; i++){
            if(counting[i] != 0) return false;
        }

        return true;
    }

    public static void main(String[] args){
        String s = "a";
        String t = "ab";
        boolean isAna = isAnagram(s, t);

        System.out.println(isAna);
    }
}
