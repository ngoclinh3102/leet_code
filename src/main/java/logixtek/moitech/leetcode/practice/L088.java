package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L088 {

    public static void main(String[] args) {
        merge(new int[]{1,3,5,7,0,0,0}, 4, new int[]{2,4,6}, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1;
        while (n > 0){
            if (m > 0 && nums1[m-1] > nums2[n-1]) {
                nums1[i] = nums1[m-1];
                m--;
            }
            else {
                nums1[i] = nums2[n-1];
                n--;
            }
            i--;
        }
        System.out.println(Arrays.toString(nums1));
    }
}
