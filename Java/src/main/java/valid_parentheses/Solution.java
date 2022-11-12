package valid_parentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static boolean isValid(String s) {
        char[] charArray = s.toCharArray();

        if(charArray.length == 0)
            return true;

        if(charArray.length%2 != 0)
            return false;

        Map<Character, Character> storage = new HashMap<>();
        storage.put('(', ')');
        storage.put('{', '}');
        storage.put('[', ']');

        List<Character> list = new ArrayList<>();
        for(char c: charArray){
            if(c=='(' || c=='{' || c=='['){
                list.add(0, c);
            }
            if(c==')' || c=='}' || c==']'){
                if (c!=storage.get(list.get(0))){
                    return false;
                } else {
                    list.remove(0);
                }
            }
        }

        if(list.size() != 0)
            return false;

        return true;
    }

    public static void main(String[] args){
        String s="((";
        boolean isValid = isValid(s);

        List<Integer> listInt = new ArrayList<>();
        if(listInt.size() == 0){
            System.out.println("List is null");
        }

        System.out.println(isValid);
    }
}
