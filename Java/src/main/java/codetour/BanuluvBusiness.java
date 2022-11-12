package codetour;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BanuluvBusiness {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        List<List<Integer>> trac = new ArrayList<>();

        for(int i=0; i<m; i++){
            int no = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for(int k=0; k<no; k++){
                int product = sc.nextInt();
                list.add(product);
            }
            trac.add(list);
        }

//        while()

        sc.close();
    }
}
