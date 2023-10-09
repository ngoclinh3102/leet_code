package logixtek.moitech.leetcode.practice;

public class L004 {

    public static void main(String[] args) {
//        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2})); // 2.0
//        System.out.println(findMedianSortedArrays(new int[]{1,2,3,4,5}, new int[]{4,5,6,7,8,9})); // 5.0
//        System.out.println(findMedianSortedArrays(new int[]{9}, new int[]{1,2,3,4,5,6})); // 4.0
        System.out.println("// == == == //");
        System.out.println(findMedianSortedArrays(new int[]{5, 7, 8, 11}, new int[]{4, 9, 12, 14})); // 8.5
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{-1, 3})); // 1.5
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = nums1.length;
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (nums1.length + nums2.length + 1) / 2 - partitionX;

            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];

            int minX = (partitionX == nums1.length) ? Integer.MAX_VALUE : nums1[partitionX];
            int minY = (partitionY == nums2.length) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxX <= minY && maxY <= minX) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2.0;
                }
                else {
                    return Math.max(maxX, maxY);
                }
            }
            else if (maxX > minY) {
                high = partitionX - 1;
            }
            else {
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}
