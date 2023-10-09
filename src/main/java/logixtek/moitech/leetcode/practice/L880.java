package logixtek.moitech.leetcode.practice;

public class L880 {

    public static void main(String[] args) {
        System.out.println(decodeAtIndex("y959q969u3hb22odq595",222_280_369)); // y
    }

    public static String decodeAtIndex(String s, int k) {
        char c;
        int i;
        long decodedLen = 0;

        for (i = 0; decodedLen < k; i++) {
            c = s.charAt(i);
            if (c >= '2' && c <= '9') decodedLen *= (c - '0');
            else decodedLen++;
        }

        for (i = i - 1; i >= 0; i--) {
            c = s.charAt(i);
            if (c >= '2' && c <= '9') {
                decodedLen /= (c - '0');
                k %= decodedLen;
            }
            else {
                if (k == 0 || k == decodedLen) {
                    return String.valueOf(c);
                }
                decodedLen--;
            }
        }

        return null;
    }
}
