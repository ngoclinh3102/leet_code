package logixtek.moitech.leetcode.practice;

public class L746 {

    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length > 1) {
            int[] cheapestCost = new int[cost.length];
            for (int i = cost.length - 3; i >= 0; i--) {
                cheapestCost[i] = Math.min(cheapestCost[i + 1] + cost[i + 1], cheapestCost[i + 2] + cost[i + 2]);
            }
            return Math.min(cheapestCost[0] + cost[0], cheapestCost[1] + cost[1]);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20})); // 15
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1})); // 6
        System.out.println(minCostClimbingStairs(new int[]{0, 2, 2, 1})); // 2
    }
}
