package reverse_polish_notation;

import java.util.Stack;

public class Solution {
    public static Stack<Integer> sta = new Stack<Integer>();

    public static boolean isNumeric(String str){
        try {
            int i = Integer.parseInt(str);
        } catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    public static int evalRPN(String[] tokens) {
        int result = 0;

        if(tokens.length == 0){
            return 0;
        }

        for(String str: tokens){
            if(!isNumeric(str)){
                char ch = str.charAt(0);
                if(ch == '+'){
                    int a = sta.pop();
                    int b = sta.pop();
                    int hey = a+b;
                    sta.push(hey);
                } else if(ch == '-'){
                    int a = sta.pop();
                    int b = sta.pop();
                    int hey = b-a;
                    sta.push(hey);
                } else if(ch == '*'){
                    int a = sta.pop();
                    int b = sta.pop();
                    int hey = a*b;
                    sta.push(hey);
                } else if(ch == '/'){
                    int a = sta.pop();
                    int b = sta.pop();
                    int hey = b/a;
                    sta.push(hey);
                }
            } else {
                int no = Integer.parseInt(str);
                sta.push(no);
            }
        }
        result = sta.pop();

        return result;
    }

    public static void main(String[] args){
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int result = evalRPN(tokens);

        System.out.println(result);
//        System.out.println(6/-13);
    }
}
