package logixtek.moitech.leetcode.practice;

public class L2849 {
    public static void main(String[] args) {

    }

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        return (sx == fx && sy == fy) ? t != 1 : t >= Math.max(Math.abs(sx - fx), Math.abs(sy - fy));
    }
}
