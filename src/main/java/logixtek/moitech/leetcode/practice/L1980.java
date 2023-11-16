package logixtek.moitech.leetcode.practice;

public class L1980 {
    public static void main(String[] args) {
    }

    public static String findDifferentBinaryString(String... nums) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (String s : nums) sb.append(1 - s.charAt(i++));
        return sb.toString();
    }
}
