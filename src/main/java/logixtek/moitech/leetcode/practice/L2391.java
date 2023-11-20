package logixtek.moitech.leetcode.practice;

public class L2391 {
    public static void main(String[] args) {
        System.out.println(garbageCollection(new String[]{}, new int[]{}));
    }

    public static int garbageCollection(String[] garbage, int[] travel) {
        int counts = 0;
        int lastSeenMetal = 0;
        int lastSeenPaper = 0;
        int lastSeenGlass = 0;

        for (int i = 1; i < travel.length; i++) {
            travel[i] += travel[i-1];
        }

        for (int i = 0; i < garbage.length; i++) {
            counts += garbage[i].length();
            if (garbage[i].indexOf('M') != -1) lastSeenMetal = i;
            if (garbage[i].indexOf('P') != -1) lastSeenPaper = i;
            if (garbage[i].indexOf('G') != -1) lastSeenGlass = i;
        }

        if (lastSeenMetal > 0) counts += travel[lastSeenMetal - 1];
        if (lastSeenPaper > 0) counts += travel[lastSeenPaper - 1];
        if (lastSeenGlass > 0) counts += travel[lastSeenGlass - 1];

        return counts;
    }
}
