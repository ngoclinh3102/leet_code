package logixtek.moitech.leetcode.practice.structure.impl;

import logixtek.moitech.leetcode.practice.structure.NestedInteger;

import java.util.List;

public class NestedIntegerImpl implements NestedInteger {

    private final int dummy;

    public NestedIntegerImpl(int dummy) {
        this.dummy = dummy;
    }

    @Override
    public boolean isInteger() {
        return false;
    }

    @Override
    public Integer getInteger() {
        return dummy;
    }

    @Override
    public List<NestedInteger> getList() {
        return null;
    }
}
