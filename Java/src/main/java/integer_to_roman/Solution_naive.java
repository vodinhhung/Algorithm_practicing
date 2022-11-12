package integer_to_roman;

import java.util.ArrayList;
import java.util.List;

public class Solution_naive {
    public static String intToRoman(int num) {
        int a = num%10;
        int b = (num%100 - a)/10;
        int d = num/1000;
        int c = num/100 - 10*d;

        List<Character> result = new ArrayList<>();

        if(a==9){
            result.add(0, 'X');
            result.add(0, 'I');
        } else if(a==4){
            result.add(0, 'V');
            result.add(0, 'I');
        } else {
            while(a>0){
                if(a==5){
                    result.add(0, 'V');
                    break;
                } else{
                    result.add(0, 'I');
                    a--;
                }
            }
        }

        if(b==9){
            result.add(0, 'C');
            result.add(0, 'X');
        } else if(b==4){
            result.add(0, 'L');
            result.add(0, 'X');
        } else {
            while(b>0){
                if(b==5){
                    result.add(0, 'L');
                    break;
                } else{
                    result.add(0, 'X');
                    a--;
                }
            }
        }

        if(c==9){
            result.add(0, 'M');
            result.add(0, 'C');
        } else if(c==4){
            result.add(0, 'D');
            result.add(0, 'C');
        } else {
            while(c>0){
                if(c==5){
                    result.add(0, 'D');
                    break;
                } else{
                    result.add(0, 'C');
                    c--;
                }
            }
        }

        while(d>0){
            d--;
            result.add(0,'M');
        }

        StringBuilder sb = new StringBuilder();
        for (char s : result)
        {
            sb.append(String.valueOf(s));
            sb.append("");
        }

        return sb.toString();
    }

    public static void main(String[] args){
        int num = 4;
        String s = intToRoman(num);

        System.out.println(s);
    }
}
