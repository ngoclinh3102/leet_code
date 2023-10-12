package logixtek.moitech.leetcode.practice;

public class L122 {

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int s;
            if ((s = prices[i] - prices[i-1]) > 0) {
                profit += s;
            }
        }
        return profit;
    }
}
