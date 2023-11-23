package logixtek.moitech.leetcode.practice;

import org.springframework.stereotype.Component;

import java.util.*;

@Component("MEDIUM")
public class L630 {
    public static void main(String[] args) {
        int[][] courses = {{9,10},{3,12},{7,17},{4,18},{10,19},{5,20},{10,20}};
        System.out.println(scheduleCourse(courses));
    }

    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (c1, c2) -> c1[1] == c2[1] ? c1[0] - c2[0] : c1[1] - c2[1]);

        PriorityQueue<Integer> queue = new PriorityQueue<>((i1, i2) -> courses[i2][0] != courses[i1][0] ? courses[i2][0] - courses[i1][0] : i2 - i1);

        int numOfCourses = 0;
        int totalDays = 0;
        for (int i = 0; i < courses.length; i++) {
            int duration = courses[i][0];
            int lastDay = courses[i][1];

            if (duration > lastDay) continue;

            if (totalDays + duration <= lastDay) {
                totalDays += duration;
                numOfCourses++;
                queue.offer(i);
            }
            else {
                int j = queue.peek();
                if (courses[j][0] > duration) {
                    queue.poll();
                    queue.offer(i);
                    totalDays = totalDays + duration - courses[j][0];
                }
            }
        }

        return numOfCourses;
    }
}
