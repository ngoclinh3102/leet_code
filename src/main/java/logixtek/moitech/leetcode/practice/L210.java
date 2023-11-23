package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class L210 {
    public static void main(String[] args) {
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(findOrder(4, prerequisites)));
    }

    private static int ordering;

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ordering = 0;
        ArrayList<Integer>[] requiredCourses = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            requiredCourses[i] = new ArrayList<>();
        }

        for (int[] pair : prerequisites) {
            requiredCourses[pair[0]].add(pair[1]);
        }

        int[] completed = new int[numCourses]; // -2 = new, -1 = in progress, >= 0 = done
        Arrays.fill(completed, -2);

        for (int course = 0; course < numCourses; course++) {
            if (completed[course] == -2 && isConflicted(requiredCourses, completed, course)) {
                return new int[]{};
            }
        }

        int[] schedule = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            schedule[completed[i]] = i;
        }

        return schedule;
    }

    private static boolean isConflicted(ArrayList<Integer>[] requiredCourses, int[] completed, int course) {
        completed[course] = -1;

        for (int prerequisite : requiredCourses[course]) {
            if (completed[prerequisite] == -1) return true;
            if (completed[prerequisite] == -2 && isConflicted(requiredCourses, completed, prerequisite)) return true;
        }

        completed[course] = ordering++;
        return false;
    }
}
