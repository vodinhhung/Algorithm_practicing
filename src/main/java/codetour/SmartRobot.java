package codetour;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SmartRobot {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        Map<Integer, Boolean> map = new HashMap<>();
        int result = 0;

        for(int i=0; i<testcase; i++){
            int m = sc.nextInt();
            int n = sc.nextInt();

            if(map.containsKey(n-m) && m!=n){
                result++;
                boolean bo = map.remove(n-m);
            } else map.put(m-n, true);
        }

        System.out.print(result);

        sc.close();
    }
}
