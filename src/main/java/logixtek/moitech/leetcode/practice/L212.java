package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class L212 {

    // TODO

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(findWords(board, new String[]{"ABCCED"}));
    }

    private static final List<String> list = new ArrayList<>();

    public static List<String> findWords(char[][] board, String[] words) {
        return list;
    }
}
