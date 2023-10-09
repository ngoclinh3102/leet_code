package logixtek.moitech.leetcode.practice;

public class L079 {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(exist(board, "ABCCED")); // true
        System.out.println(exist(new char[][]{{'a','b'}}, "ab")); // false
    }

    public static boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        checkEndsFrequency(board, w);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == w[0]) {
                    board[i][j] = '*';
                    if (search(board, w, i, j, 1)) return true;
                    board[i][j] = w[0];
                }
            }
        }
        return false;
    }

    private static boolean search(char[][] board, char[] word, int i, int j, int length) {
        if (length == word.length) return true;

        if (i > 0 && board[i-1][j] == word[length]) {
            board[i-1][j] = '*';
            if (search(board, word, i-1, j, length + 1)) return true;
            board[i-1][j] = word[length];
        }

        if (j > 0 && board[i][j-1] == word[length]) {
            board[i][j-1] = '*';
            if (search(board, word, i, j-1, length + 1)) return true;
            board[i][j-1] = word[length];
        }

        if (i + 1 < board.length && board[i+1][j] == word[length]) {
            board[i+1][j] = '*';
            if (search(board, word, i+1, j, length + 1)) return true;
            board[i+1][j] = word[length];
        }

        if (j + 1 < board[0].length && board[i][j+1] == word[length]) {
            board[i][j+1] = '*';
            if (search(board, word, i, j+1, length + 1)) return true;
            board[i][j+1] = word[length];
        }

        return false;
    }

    private static void checkEndsFrequency(char[][] board, char[] word) {
        if (word[0] != word[word.length - 1]) {
            int firstCharCount = 0;
            int lastCharCount = 0;
            for (char[] row : board) {
                for (char c : row) {
                    if (c == word[0]) firstCharCount++;
                    if (c == word[word.length - 1]) lastCharCount++;
                }
            }
            if (lastCharCount > firstCharCount) {
                for (int i = 0; i < word.length / 2; i++) {
                    char temp = word[i];
                    word[i] = word[word.length - 1 - i];
                    word[word.length - 1 - i] = temp;
                }
            }
        }
    }
}
