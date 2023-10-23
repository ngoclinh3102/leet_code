package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.NestedIterator;
import logixtek.moitech.leetcode.practice.structure.impl.NestedIntegerImpl;

import java.util.List;

public class L341 {

    public static void main(String[] args) {
        NestedIterator iterator = new NestedIterator(List.of(new NestedIntegerImpl(1)));
        System.out.println(iterator.next());
    }
}
