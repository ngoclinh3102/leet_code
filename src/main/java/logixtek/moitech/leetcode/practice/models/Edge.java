package logixtek.moitech.leetcode.practice.models;

public class Edge {
    public int p1;
    public int p2;
    public int weight;

    public Edge(int p1, int p2, int weight) {
        this.p1 = p1;
        this.p2 = p2;
        this.weight = weight;
    }

    public static Edge of(int p1, int p2, int weight) {
        return new Edge(p1, p2, weight);
    }
}
