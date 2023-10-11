package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.MyCalendar;

public class L729 {
    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(47, 50));
        System.out.println(calendar.book(33, 41));
        System.out.println(calendar.book(39, 45));
        System.out.println(calendar.book(33, 42));
        System.out.println(calendar.book(25, 32));
        System.out.println(calendar.book(26, 35));
        System.out.println(calendar.book(19, 25));
        System.out.println(calendar.book(3, 8));
        System.out.println(calendar.book(8, 13));
        System.out.println(calendar.book(18, 27));
    }
}
