package logixtek.moitech.leetcode.practice;

public class L135 {
    public static void main(String[] args) {
        System.out.println(candy(1,0,2)); // 5
        System.out.println(candy(1,2,2)); // 4
        System.out.println(candy(5, 8, 12, 3, 0, 9, 6, 1, 7, 2, 4, 10)); // 23
    }

    public static int candy(int... ratings) {
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for (int i = 1; i < candies.length; i++) {
            candies[i] = 1;
            if (ratings[i] > ratings[i-1]) {
                candies[i] += candies[i-1];
            }
        }
        int totalCandies = candies[candies.length-1];
        for (int i = candies.length - 2; i >= 0; i--) {
            if (candies[i] <= candies[i+1] && ratings[i] > ratings[i+1]) {
                candies[i] = candies[i+1] + 1;
            }
            totalCandies += candies[i];
        }
        return totalCandies;
    }
}
