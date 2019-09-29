package length_last_word;

public class Solution_optimism {
    public static int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;

        int a = s.length()-1;
        while(a>=0 && s.charAt(a) == 32)
            a--;

        if(a == -1) return 0;

        int b=a;
        while(b>=0 && s.charAt(b) != 32)
            b--;

        return a-b;
    }

    public static void main(String[] args){
        int no = lengthOfLastWord("Hello word");

        System.out.println(no);
    }
}
