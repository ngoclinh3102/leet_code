package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.models.Edge;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class L1584 {

    public static void main(String[] args) {
        System.out.println(minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));
    }

    public static int minCostConnectPoints(int[][] points) {
        int minCost = 0;
        int requiredEdges = points.length - 1;
        boolean[] visited = new boolean[points.length];
        Queue<Edge> minEdges = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        visited[0] = true;
        var firstPoint = points[0];
        for (int i = 1; i < points.length; i++) {
            minEdges.offer(Edge.of(0, i , weightOf(firstPoint, points[i])));
        }

        while (!minEdges.isEmpty() && requiredEdges > 0) {
            var edge = minEdges.poll();

            if (!visited[edge.p2]) {
                minCost += edge.weight;

                visited[edge.p2] = true;
                for (int i = 0; i < points.length; i++) {
                    if (!visited[i]) {
                        minEdges.offer(Edge.of(edge.p2, i, weightOf(points[edge.p2], points[i])));
                    }
                }
                requiredEdges--;
            }
        }

        return minCost;
    }

    public static int weightOf(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
