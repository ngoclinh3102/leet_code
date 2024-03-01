package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class L2709 {

    public static void main(String[] args) {
        System.out.println(canTraverseAllPairs(new int[]{2,3,6})); //true
        System.out.println(canTraverseAllPairs(new int[]{3,9,5})); //false
        System.out.println(canTraverseAllPairs(new int[]{4,3,12,8})); //true
        System.out.println(canTraverseAllPairs(new int[]{3,99,98})); //false
    }

    private static ArrayList<Integer> primeFactors(int number) {
        ArrayList<Integer> factors = new ArrayList<>();

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                factors.add(i);
                while (number % i == 0) {
                    number /= i;
                }
            }
        }

        if (number > 1) {
            factors.add(number);
        }

        return factors;
    }

    public static boolean canTraverseAllPairs(int[] nums) {
        if (nums.length == 1) return true;
        if (nums[0] == 1) return false;

        HashSet<Integer> sharedFactors = new HashSet<>(primeFactors(nums[0]));

        HashMap<Integer, ArrayList<Integer>> factorsMap = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                return false;
            }
            factorsMap.put(nums[i], primeFactors(nums[i]));
        }

        boolean flag = true;
        while (flag && factorsMap.size() > 0) {
            flag = false;
            ArrayList<Integer> list = new ArrayList<>(factorsMap.keySet());
            for (int num : list) {
                for (int factor : factorsMap.get(num)) {
                    if (sharedFactors.contains(factor)) {
                        sharedFactors.addAll(factorsMap.get(num));
                        factorsMap.remove(num);
                        flag = true;
                        break;
                    }
                }
            }
        }

        return factorsMap.isEmpty();
    }
}
