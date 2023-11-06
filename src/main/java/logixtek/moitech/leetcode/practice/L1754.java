package logixtek.moitech.leetcode.practice;

public class L1754 {
    public static void main(String[] args) {
        System.out.println(largestMerge("cabaa", "bcaaa"));
    }

    public static String largestMerge(String s, String t) {
        char[] sarray = s.toCharArray();
        char[] tarray = t.toCharArray();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        int j = 0;
        while (i < sarray.length && j < tarray.length) {
            if (sarray[i] > tarray[j]) {
                sb.append(sarray[i++]);
            }
            else if (sarray[i] < tarray[j]){
                sb.append(tarray[j++]);
            }
            else {
                int next = greedyCheck(sarray, tarray, i, j);
                if (next > 0) {
                    while (i < next) sb.append(sarray[i++]);
                }
                else {
                    while (j < -next) sb.append(tarray[j++]);
                }
            }
        }

        while (i < sarray.length) sb.append(sarray[i++]);
        while (j < tarray.length) sb.append(tarray[j++]);

        return sb.toString();
    }

    private static int greedyCheck(char[] sarray, char[] tarray, int i, int j) {
        char firstChar = sarray[i];
        boolean check = true;
        int nextI = i;
        int nextJ = -j;

        while (i < sarray.length && j < tarray.length) {

            check = check && firstChar == sarray[i] && firstChar == tarray[j];
            if (check) {
                nextI++;
                nextJ--;
            }

            if (sarray[i] != tarray[j]) {
                return sarray[i] > tarray[j] ? nextI : nextJ;
            }

            i++;
            j++;
        }

        return i < sarray.length ? nextI : nextJ;
    }
}
