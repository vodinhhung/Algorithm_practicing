package time_to_buy_and_sell;

public class Solution {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i] > prices[i-1])
                profit += prices[i] - prices[i-1];
        }
        return profit;
    }

    public static void main(String[] args){
        int[] prices = {1,2,3,4,5};
        int max = maxProfit(prices);

        System.out.println(max);
    }
}
