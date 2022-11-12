package palindrome;

import java.util.*;

public class Main {
	static Map<List<Integer>, Boolean> mapCheck = new HashMap<>();
    
    public static Boolean checkPalindrome(char[] arr, int i, int j){
        if(mapCheck.get(Arrays.asList(i,j)) != null){
            return mapCheck.get(Arrays.asList(i,j));
        }
        
        Boolean check = false;
        
        if(arr[i]==arr[j]){
            if(Math.abs(j-i)==1 || Math.abs(j-i)==2){
                return true;
            } else {
                return checkPalindrome(arr, i+1, j-1);
            }
        }
        mapCheck.put(Arrays.asList(i,j), check);
        
        return check;
    }
    
    public static String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int length = arr.length;
        int maxLength = 0;
        int min_index = 0;
        int max_index = 0;
        
        for(int i=0; i<length-1; i++) {
            for(int j=i+1; j<length; j++){
                if(checkPalindrome(arr, i, j) && maxLength < (j-i+1)){
                    min_index = i;
                    max_index = j;
                }
            }
        }
        
        String result = new String(arr, min_index, max_index-min_index+1);
        return result;
    }
    
    public static void main(String[] args) {
    	String s = "sdfreerdvd";
    	System.out.println(longestPalindrome(s));
    }
}
