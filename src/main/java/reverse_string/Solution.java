package reverse_string;

public class Solution {
    public static void swap(char[] s, int i, int j){
        char c = s[i];
        s[i] = s[j];
        s[j] = c;
    }

    public static void reverseString(char[] s) {
        for(int i=0; i<s.length/2; i++){
            swap(s, i, s.length-1-i);
        }
    }

    public static void main(String[] args){
        char[] s = {'h', 'e', 'l', 'l'};
        reverseString(s);

        for(int i=0; i<s.length; i++){
            System.out.println(s[i]);
        }
    }
}
