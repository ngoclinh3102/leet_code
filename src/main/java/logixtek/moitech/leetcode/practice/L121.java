package logixtek.moitech.leetcode.practice;

public class L121 {

    public static int maxProfit(int[] prices) {
        int cheapest = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - cheapest > profit) {
                profit = prices[i] - cheapest;
            }
            if (prices[i] < cheapest) {
                cheapest = prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4})); // 5
        System.out.println(maxProfit(new int[] {7,6,4,3,1})); // 0
    }
}
