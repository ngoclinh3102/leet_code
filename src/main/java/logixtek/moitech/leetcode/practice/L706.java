package logixtek.moitech.leetcode.practice;


import logixtek.moitech.leetcode.practice.structure.MyHashMap;

public class L706 {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1,100);
        map.put(2,200);
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        map.put(1,1000);
        map.put(2,2000);
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));
        map.remove(2);
        System.out.println(map.get(2));
        map.remove(2);
    }
}
