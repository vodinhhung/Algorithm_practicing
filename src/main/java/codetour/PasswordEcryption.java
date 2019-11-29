package codetour;

import java.util.Scanner;

public class PasswordEcryption {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();

        for(int i=0; i<testcase; i++){
            int t = sc.nextInt();
            String s = sc.next();

            char[] cha = s.toCharArray();
            for(int k=0; k<cha.length; k++){
                char c = cha[k];
                int x = (c+t)>'z'? (c+t-'z'+'a'-1):(c+t);
                cha[k] = (char) x;
            }

            System.out.println(String.valueOf(cha));
        }

        sc.close();
    }
}
