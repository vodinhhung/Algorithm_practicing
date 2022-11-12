package excel_sheet_column;

/*
leetcode 171
 */
public class Solution {
    public static int titleToNumber(String s) {
        char[] ch = s.toCharArray();
        int result = 0;
        for(int i=0; i<ch.length; i++){
            double po = Math.pow((double)('Z'-'A'+1), (double)ch.length-i-1);
            result += (int) (ch[i]-'A'+1)*po;
        }
        return result;
    }
     public static void main(String[] args){
        int result = titleToNumber("ZY");
        System.out.println(result);
     }
}
