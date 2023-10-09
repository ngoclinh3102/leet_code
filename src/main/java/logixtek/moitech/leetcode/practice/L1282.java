package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L1282 {
    public static void main(String[] args) {
        System.out.println(groupThePeople(3,3,3,3,3,1,3));
        System.out.println(groupThePeople(2,1,3,3,3,2));
        System.out.println(groupThePeople(3,3,3,3,3,1,3,1,1,2,2,1,3));
    }

    public static List<List<Integer>> groupThePeople(int... groupSizes) {
        List<List<Integer>> groups = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            var tempList = map.computeIfAbsent(groupSizes[i], k -> new ArrayList<>());
            tempList.add(i);

            if (tempList.size() == groupSizes[i]) {
                groups.add(tempList);
                map.remove(groupSizes[i]);
            }
        }

        return groups;
    }
}
