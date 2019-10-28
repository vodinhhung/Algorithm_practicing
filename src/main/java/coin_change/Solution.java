package coin_change;

import java.util.Arrays;

public class Solution {
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        return coinChange(coins, amount, coins.length-1);
    }

    public static int coinChange(int[] coins, int amount, int index){
        int local = amount/coins[index];
        amount -= local*coins[index];
        if(amount == 0) return local;
        if(index == 0){
            return -1;
        }
        int change = coinChange(coins, amount, index-1);
        if(change == -1)
            return -1;
        else
            return local + coinChange(coins, amount, index-1);
    }

    public static void main(String[] args){
        int[] coins = {183, 419, 83, 408};
        int result = coinChange(coins, 6249);
        System.out.println(result);
    }
}
