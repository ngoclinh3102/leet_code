package logixtek.moitech.leetcode.practice;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("MEDIUM")
public class L2050 {
    public static void main(String[] args) {
        int[][] relations = {{1,3},{2,3}};
        int[] time = {3,2,5};
        int n = 3;
        System.out.println(minimumTime(n, relations, time));
    }

    public static int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<Integer>[] prerequisites = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            prerequisites[i] = new ArrayList<>();
        }
        for (int[] relation : relations) {
            prerequisites[relation[1]].add(relation[0]);
        }

        int minTime = 0;
        boolean[] visited = new boolean[n+1];
        for (int course = 1; course <= n; course++) {
            minTime = Math.max(minTime, find(prerequisites, time, visited, course));
        }

        return minTime;
    }

    private static int find(ArrayList<Integer>[] prerequisites, int[] time, boolean[] visited, int course) {
        if (visited[course]) return time[course-1];

        int longestPath = 0;
        for (int prerequisite : prerequisites[course]) {
            longestPath = Math.max(longestPath, find(prerequisites, time, visited, prerequisite));
        }

        visited[course] = true;
        return time[course-1] += longestPath;
    }
}
