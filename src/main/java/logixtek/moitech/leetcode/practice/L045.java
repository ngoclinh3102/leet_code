package logixtek.moitech.leetcode.practice;

public class L045 {
    public static int jump(int[] nums) {
        int jumps = 0;
        int curEnd = 0;
        int curFarthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[] {2,3,1,1,4}));
        System.out.println(jump(new int[] {2,3,0,1,4}));
    }
}
