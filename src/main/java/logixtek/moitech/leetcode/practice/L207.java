package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;

public class L207 {
    public static void main(String[] args) {
//        int[][] prerequisites = {{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}};
//        int[][] prerequisites = {{0, 1}, {2, 3}, {1, 2}, {3, 0}};
        int[][] prerequisites = {{2, 1}, {1, 0}};
        System.out.println(canFinish(4, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] requiredCourses = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            requiredCourses[i] = new ArrayList<>();
        }

        for (int[] pair : prerequisites) {
            requiredCourses[pair[0]].add(pair[1]);
        }

        int[] completed = new int[numCourses]; // 0 = new, 1 = in progress, 2 = done

        for (int course = 0; course < numCourses; course++) {
            if (completed[course] == 0 && isConflicted(requiredCourses, completed, course)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isConflicted(ArrayList<Integer>[] requiredCourses, int[] completed, int course) {
        completed[course] = 1;

        for (int prerequisite : requiredCourses[course]) {
            if (completed[prerequisite] == 1) return true;
            if (completed[prerequisite] == 0 && isConflicted(requiredCourses, completed, prerequisite)) return true;
        }

        completed[course] = 2;
        return false;
    }
}
