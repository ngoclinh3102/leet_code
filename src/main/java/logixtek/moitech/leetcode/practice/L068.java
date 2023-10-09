package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class L068 {

    public static void main(String[] args) {
        var list1 = fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        var list2 = fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16);
        var list3 = fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20);
        for (String s : list1) System.out.println(s); System.out.println();
        for (String s : list2) System.out.println(s); System.out.println();
        for (String s : list3) System.out.println(s); System.out.println();
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();

        int i, j;
        int currentWidth;
        for (i = 0; i < words.length; i++) {
            currentWidth = words[i].length();
            j = i;
            while ((j + 1 < words.length) && (currentWidth + words[j + 1].length() + j + 1 - i <= maxWidth)) {
                currentWidth += words[j + 1].length();
                j++;
            }
            list.add(justify(maxWidth, i, j, words));
            i = j;
        }

        return list;
    }

    private static String justify(int maxWidth, int i, int j, String... words) {
        StringBuilder answer = new StringBuilder();

        if (j == words.length - 1) {
            for (int k = i; k < j; k++) answer.append(words[k]).append(" ");
            answer.append(words[j]);
            answer.append(" ".repeat(maxWidth - answer.length()));
            return answer.toString();
        }

        int totalSpaceLeft = maxWidth;
        for (int k = i; k <= j; k++) totalSpaceLeft -= words[k].length();

        if (i < j) {
            int defaultSpace = totalSpaceLeft / (j - i);
            totalSpaceLeft -= defaultSpace * (j - i);

            for (int k = i; k < j; k++) {
                answer.append(words[k]).append(" ".repeat(defaultSpace));
                if (totalSpaceLeft > 0) {
                    answer.append(" ");
                    totalSpaceLeft--;
                }
            }
        }

        return answer.append(words[j]).append(" ".repeat(totalSpaceLeft)).toString();
    }
}
