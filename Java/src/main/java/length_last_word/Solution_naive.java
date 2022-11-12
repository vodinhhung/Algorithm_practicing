package length_last_word;

public class Solution_naive {
    public static int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] ch = s.toCharArray();
        int end = ch.length-1;
        if(ch[ch.length-1] == 32) end = ch.length-2;
        for(int i=ch.length-2; i>=0; i--){
            if(ch[i] != 32 && ch[i+1] == 32)
                end = i;
            if(ch[i] == 32 && ch[i+1] != 32)
                return end-i;
        }
        return end+1;
    }

    public static void main(String[] args){
        String s = "    ";
        int length = lengthOfLastWord(s);

        System.out.println(length);
    }
}
