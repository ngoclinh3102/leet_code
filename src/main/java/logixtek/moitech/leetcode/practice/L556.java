package logixtek.moitech.leetcode.practice;

public class L556 {

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(2147483647));
    }

    public static int nextGreaterElement(int n) {
        int nextGreater = n;
        int[] digits = new int[String.valueOf(nextGreater).length()];

        for (int i = 0; i < digits.length; i++) {
            digits[digits.length - i - 1] = nextGreater % 10;
            nextGreater /= 10;
        }

        nextPermutation(digits);

        nextGreater = 0;
        for (int digit : digits) nextGreater = nextGreater * 10 + digit;

        return nextGreater > n ? nextGreater : -1;
    }

    private static void nextPermutation(int[] nums) {
        int n = nums.length - 1;
        while (n > 0) {
            if (nums[n] > nums[n - 1]) break;
            n--;
        }

        if (n > 0) {
            int replaceIndex = minReplaceable(nums, n);
            swap(nums, n-1, replaceIndex);
        }

        revert(nums, n);
    }

    private static int minReplaceable(int[] nums, int from) {
        int key = nums[from - 1];
        int replaceableIndex = from;

        for (int i = from; i < nums.length; i++) {
            if (nums[i] <= nums[replaceableIndex] && nums[i] > key) {
                replaceableIndex = i;
            }
        }

        return replaceableIndex;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void revert(int[] nums, int from) {
        int startIndex = from;
        int endIndex = nums.length - 1;

        while (startIndex < endIndex) {
            swap(nums, startIndex, endIndex);
            startIndex++;
            endIndex--;
        }
    }
}
