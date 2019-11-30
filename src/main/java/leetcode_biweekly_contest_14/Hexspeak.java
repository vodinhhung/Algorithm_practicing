package leetcode_biweekly_contest_14;

public class Hexspeak {
    public static String toHexspeak(String num) {
        long no = Long.parseLong(num);
        String s = Long.toHexString(no);
        System.out.print(s);
        char[] cha = s.toCharArray();
        char[] list = new char[cha.length];

        for(int i=0; i<cha.length; i++){
            if(cha[i] == '0') list[i] = 'O';
            if(cha[i] == '1') list[i] = 'I';
            if(cha[i] == 'a') list[i] = 'A';
            if(cha[i] == 'b') list[i] = 'B';
            if(cha[i] == 'c') list[i] = 'C';
            if(cha[i] == 'd') list[i] = 'D';
            if(cha[i] == 'e') list[i] = 'E';
            if(cha[i] == 'f') list[i] = 'F';
            if(Character.getNumericValue(cha[i])>1 && Character.getNumericValue(cha[i])<0) return "ERROR";
        }

        return new String(list);
    }

    public static void main(String[] args){
        String num = "619879596177";
        String result = toHexspeak(num);

        System.out.print(result);
    }
}
