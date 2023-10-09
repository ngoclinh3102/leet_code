package logixtek.moitech.leetcode.practice;

public class L042 {

    public static void main(String[] args) {
        System.out.println(trap(0,1,0,2,1,0,1,3,2,1,2,1)); // 6
        System.out.println(trap(4,2,0,3,2,5)); // 9
        System.out.println(trap(1,3,2,2,1)); // 0

    }

    public static int trap(int... height) {
        int roof = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[roof]) {
                roof = i;
            }
        }

        int capacity = 0;

        for (int i = 1; i < roof; i++) {
            if (height[i-1] > height[i]) {
                capacity += (height[i-1] - height[i]);
                height[i] = height[i-1];
            }
        }

        for (int i = height.length - 2; i > roof ; i--) {
            if (height[i+1] > height[i]) {
                capacity += (height[i+1] - height[i]);
                height[i] = height[i+1];
            }
        }

        return capacity;
    }
}
