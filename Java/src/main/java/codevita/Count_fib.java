package codevita;

import java.util.Scanner;

public class Count_fib {
    public static int countFib(int n, int[] fib){
        if(n==1) fib[n-1] = 1;
        if(n==2) fib[n-1] = 2;
        if(fib[n-1] == 0) {
            fib[n-1] = countFib(n-1, fib) + countFib(n-2, fib);
        }
        return fib[n-1];
    }

    public static int[] generateArr(int n){
        int[] fib = new int[n];
        countFib(n, fib);
        return fib;
    }

    public static int countModulo(int n, int m){
        int[] fib = generateArr(n);
        int result = (fib[0]*fib[0])%m;
        for(int i=1; i<n; i++){
            result = (result + (fib[i]*fib[i])%m)%m;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 0;
        n = sc.nextInt();
        int m = 6;
        int re = countModulo(n,3);
        System.out.println(re);
    }
}
