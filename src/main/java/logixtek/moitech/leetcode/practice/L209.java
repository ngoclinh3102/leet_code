package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L209 {

    public static void main(String[] args) {
        int[] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
        for (int i = 1; i < nums.length; i++) nums[i] += nums[i-1];
        System.out.println(Arrays.toString(nums));


//        System.out.println(minSubArrayLen(7, 2, 3, 1, 2, 4, 3)); // 2
    }

    public static int minSubArrayLen(int target, int... nums) {
        int minLen = nums.length + 1;
        int sumSubarray = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            sumSubarray += nums[j];
            while (i <= j && sumSubarray - nums[i] >= target) {
                sumSubarray -= nums[i];
                i++;
            }
            if (sumSubarray >= target && minLen > j - i + 1) {
                minLen = j - i + 1;
            }
        }

        return minLen <= nums.length ? minLen : 0;
    }
}
/*
        for (int left = 0; left < nums.length; left++) {
            // ...
        }
        for (int right = 0; right < nums.length; right++) {
            // ...
        }
*/
/*
because **the sliding window approach** processes each element in the input data exactly *two times*
for example:
```
int left = 0;
int right = 0;
while (right < n) {
    while (left <= right && otherConditions) {
        // ...
        left++;
    }
    // ...
    right++;
}
```
* */