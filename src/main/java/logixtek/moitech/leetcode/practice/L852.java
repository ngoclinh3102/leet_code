package logixtek.moitech.leetcode.practice;

public class L852 {

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(1,2,3,4,5,3,1)); // 4
        System.out.println(peakIndexInMountainArray(0,1,0)); // 1
        System.out.println(peakIndexInMountainArray(0,2,1,0)); // 1
        System.out.println(peakIndexInMountainArray(0,10,5,2)); // 1
    }

    public static int peakIndexInMountainArray(int... arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) >>> 1;

            if (arr[mid] < arr[mid+1]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        return left;
    }
}
