package logixtek.moitech.leetcode.practice;

public class L011 {

    public static void main(String[] args) {
        System.out.println(maxArea(1,1)); // 1
        System.out.println(maxArea(1,8,6,2,5,4,8,3,7)); // 49
    }
    public static int maxArea(int... height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            maxArea = Math.max(maxArea, (j-i) * ((height[i] < height[j]) ? height[i++] : height[j--]));
        }
        return maxArea;
    }
}
