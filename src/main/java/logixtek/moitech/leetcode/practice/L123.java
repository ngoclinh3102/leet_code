package logixtek.moitech.leetcode.practice;

public class L123 {

    public static void main(String[] args) {
        System.out.println(maxProfit(3,3,5,0,0,3,1,4)); // 6
        System.out.println(maxProfit(1,2,3,4,5)); // 4
    }

    public static int maxProfit(int... prices) {
        int[] profits = new int[prices.length];

        int lowest = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profits[i] = Math.max(prices[i] - lowest, profits[i-1]);

            if (lowest > prices[i]) {
                lowest = prices[i];
            }
        }

        int maxProfit = profits[prices.length-1];

        int highest = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            maxProfit = Math.max(maxProfit, highest - prices[i] + profits[i]);

            if (highest < prices[i]) {
                highest = prices[i];
            }
        }

        return maxProfit;
    }
}
