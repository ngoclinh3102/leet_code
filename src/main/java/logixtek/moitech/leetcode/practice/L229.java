package logixtek.moitech.leetcode.practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class L229 {

    public static void main(String[] args) {
        System.out.println(majorityElement(3,2,3));
    }

    public static List<Integer> majorityElement(int... nums) {
        int k = nums.length / 3;
        List<Integer> answer = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.merge(n, 1, Integer::sum);
        for (var key : map.keySet()) {
            if (map.get(key) > k) {
                answer.add(key);
            }
        }
        return answer;
    }
}
