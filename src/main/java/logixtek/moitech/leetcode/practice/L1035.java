package logixtek.moitech.leetcode.practice;

public class L1035 {

    public static void main(String[] args) {
        System.out.println(maxUncrossedLines(new int[]{1}, new int[]{1,1})); // 1
        System.out.println(maxUncrossedLines(new int[]{1,4,2}, new int[]{1,2,4})); // 2
        System.out.println(maxUncrossedLines(new int[]{1,3,7,1,7,5}, new int[]{1,9,2,5,1})); // 2
        System.out.println(maxUncrossedLines(new int[]{2,5,1,2,5}, new int[]{10,5,2,1,5,2})); // 3
    }

    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                dp[i][j] = nums1[i-1] == nums2[j-1] ? (dp[i-1][j-1] + 1) : Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[nums1.length][nums2.length];
    }
}
