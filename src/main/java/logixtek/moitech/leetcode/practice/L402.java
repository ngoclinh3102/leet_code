package logixtek.moitech.leetcode.practice;

import java.util.LinkedList;

public class L402 {
    public static void main(String[] args) {

    }

    public String removeKDigits(String num, int k) {
        char[] narray = num.toCharArray();
        StringBuilder sb = new StringBuilder();
        LinkedList<Character> monostack = new LinkedList<>();

        int i = 0;
        for (int j = 0; j + k < narray.length; j++) {
            if (i < narray.length) {
                do {
                    while (monostack.size() > 0 && monostack.getLast() > narray[i]) {
                        monostack.removeLast();
                    }
                    monostack.addLast(narray[i++]);
                } while (i <= k);
            }

            char ch = monostack.removeFirst();
            if (sb.length() > 0 || ch != '0') {
                sb.append(ch);
            }
        }

        return sb.length() > 0 ? sb.toString() : "0";
    }
}
