package logixtek.moitech.leetcode.practice.structure;

public class MyCalendar {

    private final int[][] CALENDAR;
    private int size;

    public MyCalendar() {
        CALENDAR = new int[1111][2];
        size = 0;
    }

    public boolean book(int start, int end) {
        for (int i = 0; i < size; i++) {
            var booking = CALENDAR[i];
            if (start < booking[1] && end > booking[0]) {
                return false;
            }
        }

        CALENDAR[size][0] = start;
        CALENDAR[size][1] = end;
        size++;

        return true;
    }
}
