package logixtek.moitech.leetcode.practice;

public class L845 {

    public static void main(String[] args) {
        System.out.println(longestMountain(2,1,4,7,3,2,5)); // 5
        System.out.println(longestMountain(2,2,2)); // 0
        System.out.println(longestMountain(2,2)); // 0
    }

    public static int longestMountain(int a, int... arr) {
        int ans = 0;

        int left, right;

        for (int i = 0; i < arr.length; i++) {
            left = i;
            while (i + 2 < arr.length && arr[i+1] > arr[i]) i++;
            if (left == i) continue;

            right = i;
            while (right + 1 < arr.length && arr[right+1] < arr[right]) right++;
            if (i == right) continue;

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
