package longgest_common_prefix;

public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String result = strs[0];
        for(int i=1; i<strs.length; i++){
            while(!strs[i].startsWith(result) && result.length()>0){
                result = result.substring(0, result.length()-1);
            }
        }
        return result;
    }

    public static void main(String[] args){
        String[] strs = new String[]{};
        System.out.println(strs.length);
        String result = longestCommonPrefix(strs);

        System.out.println(result);
    }
}
