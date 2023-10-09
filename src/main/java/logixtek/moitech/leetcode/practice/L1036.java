package logixtek.moitech.leetcode.practice;

public class L1036 {

    public static void main(String[] args) {
        System.out.println(canReach(new int[] {4,2,3,0,3,1,2}, 5)); // true
        System.out.println(canReach(new int[] {4,2,3,0,3,1,2}, 0)); // true
        System.out.println(canReach(new int[] {3,0,2,1,2}, 2)); // false
    }

    public static boolean canReach2(int[] arr, int start) {
        if (arr[start] == 0) return true;
        arr[start] = -1;
        return false;
    }

    public static boolean canReach(int[] arr, int start) {
        boolean[] reachable = new boolean[arr.length];

        jump(reachable, arr, start);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && reachable[i]) {
                return true;
            }
        }

        return false;
    }

    private static void jump(boolean[] reachable, int[] arr, int start) {
        reachable[start] = true;
        if (start + arr[start] < reachable.length && !reachable[start + arr[start]]) {
            jump(reachable, arr, start + arr[start]);
        }
        if (start - arr[start] >= 0 && !reachable[start - arr[start]]) {
            jump(reachable, arr, start - arr[start]);
        }
    }
}

