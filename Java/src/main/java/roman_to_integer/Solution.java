package roman_to_integer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int romanToInt(String s) {
        // generate map
        Map<Character, Integer> con = new HashMap<>();
        con.put('I', 1);
        con.put('V', 5);
        con.put('X', 10);
        con.put('L', 50);
        con.put('C', 100);
        con.put('D', 500);
        con.put('M', 1000);

        char[] ch = s.toCharArray();
        int result = 0;
        int i=0;

        while(i<ch.length){
            if(i!= ch.length-1){
                if(ch[i] == 'I' && (ch[i+1]=='V' || ch[i+1]=='X')){
                    result = result - con.get(ch[i]) + con.get(ch[i+1]);
                    i+=2;
                    continue;
                }
                if(ch[i] == 'X' && (ch[i+1]=='L' || ch[i+1]=='C')){
                    result = result - con.get(ch[i]) + con.get(ch[i+1]);
                    i+=2;
                    continue;
                }
                if(ch[i] == 'C' && (ch[i+1]=='D' || ch[i+1]=='M')){
                    result = result - con.get(ch[i]) + con.get(ch[i+1]);
                    i+=2;
                    continue;
                }
            }

            result = result + con.get(ch[i]);
            i++;
        }

        return result;
    }

    public static void main(String[] args){
        String s = "MCMXCIV";
        int i = romanToInt(s);

        System.out.println(i);

        s = s + 2;
        System.out.println(s);
    }
}
