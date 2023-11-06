package logixtek.moitech.leetcode.practice;

import java.util.Arrays;
import java.util.LinkedList;

public class L321 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxNumber(new int[]{3,4,6,5}, new int[]{9,1,2,5,8,3}, 5)));
    }

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] answer = new int[k];
        int m = k;
        int n = 0;

        while (m >= 0) {
            if (m <= nums1.length && n <= nums2.length) {
                int[] temp = largestMerge(mostCompetitive(nums1, m), mostCompetitive(nums2, n));
                boolean isBigger = false;
                for (int i = 0; i < k; i++) {
                    if (isBigger) {
                        answer[i] = temp[i];
                    }
                    else if (answer[i] < temp[i]) {
                        isBigger = true;
                        answer[i] = temp[i];
                    }
                    else if (answer[i] > temp[i]) {
                        break;
                    }
                }
            }
            m--;
            n++;
        }

        return answer;
    }

    private static int[] mostCompetitive(int[] nums, int k) {
        int[] answer = new int[k];
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0, j = 0; j < k; j++) {
            if (i < nums.length) {
                do {
                    while (list.size() > 0 && nums[list.getLast()] < nums[i]) {
                        list.removeLast();
                    }
                    list.addLast(i++);
                } while (i <= nums.length - k);
            }

            answer[j] = nums[list.removeFirst()];
        }

        return answer;
    }

    public static int[] largestMerge(int[] nums1, int[] nums2) {
        int[] sb = new int[nums1.length + nums2.length];
        int index = 0;

        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                sb[index++] = nums1[i++];
            }
            else if (nums1[i] < nums2[j]){
                sb[index++] = nums2[j++];
            }
            else {
                int next = greedyCheck(nums1, nums2, i, j);
                if (next > 0) {
                    while (i < next) sb[index++] = nums1[i++];
                }
                else {
                    while (j < -next) sb[index++] = nums2[j++];
                }
            }
        }

        while (i < nums1.length) sb[index++] = nums1[i++];
        while (j < nums2.length) sb[index++] = nums2[j++];
        return sb;
    }

    private static int greedyCheck(int[] nums1, int[] nums2, int i, int j) {
        int first = nums1[i];
        boolean check = true;
        int nextI = i;
        int nextJ = -j;

        while (i < nums1.length && j < nums2.length) {

            check = check && first == nums1[i] && first == nums2[j];
            if (check) {
                nextI++;
                nextJ--;
            }

            if (nums1[i] != nums2[j]) {
                return nums1[i] > nums2[j] ? nextI : nextJ;
            }

            i++;
            j++;
        }

        return i < nums1.length ? nextI : nextJ;
    }
}
