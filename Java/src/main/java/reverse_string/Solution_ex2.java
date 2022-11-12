package reverse_string;

public class Solution_ex2 {
    public static boolean outOfRange(char i){
        return (i<65 || (i>90 && i<97) || i>122);
    }

    public static String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int i=0;
        int j=chars.length-1;
        while(i<j){
            if(outOfRange(chars[i])){
                i++;
                continue;
            }
            if(outOfRange(chars[j])){
                j--;
                continue;
            }
            swap(chars, i, j);
            i++;
            j--;
        }
        return new String(chars);
    }

    public static void swap(char[] ch, int i, int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    public static void main(String[] args){
        String s ="ab-cd";
        String result = reverseOnlyLetters(s);

        System.out.println(result);
    }
}
