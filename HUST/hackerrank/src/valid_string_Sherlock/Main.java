package valid_string_Sherlock;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Main {

	    // Complete the isValid function below.
	    static String isValid(String s) {
	        int[] countingArray = new int[26];
	        int average = 0;
	        int countNotAverage = 0;
	        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();

	        for (char c: s.toCharArray()) {
	            countingArray[c-97]++;
	            System.out.println(c-97);
	        }

	        for (int i=0; i<26; i++) {
	            int a = countingArray[i];
	            if(a != 0) {
	                if(freq.get(a) == null) {
	                    freq.put(a, 1);
	                } else {
	                    freq.put(a, freq.get(a) + 1);
	                }
	            }
	        }

	        for (Integer key: freq.keySet()) {
	            System.out.println(key+ ": " +freq.get(key));
	        }

	        Map.Entry<Integer, Integer> maxEntry = null;
	        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
	            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0){
	                maxEntry = entry;
	            }
	        }
	        average =  maxEntry.getKey();
	        System.out.println(average);
	        
	        for(int i=0; i<26; i++) {
	            if(countingArray[i] != 0 && countingArray[i] != average) {
	                countNotAverage++;
	                if (countNotAverage > 1) {
	                    return "NO";
	                }
	                if (Math.abs(countingArray[i] - average) > 1) {
	                    return "NO";
	                }
	            }
	        }

	        return "YES";
	    }

	    public static void main(String[] args) {
	    	String s = "abcdefgh";
	    	System.out.println(isValid(s));
	    }
}
