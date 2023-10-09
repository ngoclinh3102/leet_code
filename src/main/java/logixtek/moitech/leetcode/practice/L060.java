package logixtek.moitech.leetcode.practice;

import java.util.LinkedList;

public class L060 {

    private static final int[] ANSWER = {0, 1234, 1243, 1324, 1342, 1423, 1432, 2134, 2143, 2314, 2341, 2413, 2431, 3124, 3142, 3214, 3241, 3412, 3421, 4123, 4132, 4213, 4231, 4312, 4321};
    public static void main(String[] args) {
        for (int i = 1; i <= 24; i++) {
            String check = getPermutation(4,i);
            System.out.println(ANSWER[i] + " -> " + check + (ANSWER[i] == Integer.parseInt(check) ? "" : "   XXX"));
        }
    }
    public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();

        LinkedList<Integer> elements = new LinkedList<>();
        for (int i = 1; i <= n; i++) elements.addLast(i);

        int range = 1;
        int step = 1;
        while (step + 1 < n) {
            range *= (step + 1);
            step++;
        }

        while (k > 0) {
            sb.append(elements.remove((k - 1) / range));
            k %= range;
            range /= step;
            step--;
        }

        while (!elements.isEmpty()) sb.append(elements.removeLast());

        return sb.toString();
    }
}
