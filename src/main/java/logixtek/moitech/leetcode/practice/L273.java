package logixtek.moitech.leetcode.practice;

public class L273 {
    public static void main(String[] args) {
        System.out.println(numberToWords(100_000));
    }

    private static final String[] ENG_NUMBER = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
            "Twenty", "Twenty One", "Twenty Two", "Twenty Three", "Twenty Four", "Twenty Five", "Twenty Six", "Twenty Seven", "Twenty Eight", "Twenty Nine",
            "Thirty", "Thirty One", "Thirty Two", "Thirty Three", "Thirty Four", "Thirty Five", "Thirty Six", "Thirty Seven", "Thirty Eight", "Thirty Nine",
            "Forty", "Forty One", "Forty Two", "Forty Three", "Forty Four", "Forty Five", "Forty Six", "Forty Seven", "Forty Eight", "Forty Nine",
            "Fifty", "Fifty One", "Fifty Two", "Fifty Three", "Fifty Four", "Fifty Five", "Fifty Six", "Fifty Seven", "Fifty Eight", "Fifty Nine",
            "Sixty", "Sixty One", "Sixty Two", "Sixty Three", "Sixty Four", "Sixty Five", "Sixty Six", "Sixty Seven", "Sixty Eight", "Sixty Nine",
            "Seventy", "Seventy One", "Seventy Two", "Seventy Three", "Seventy Four", "Seventy Five", "Seventy Six", "Seventy Seven", "Seventy Eight", "Seventy Nine",
            "Eighty", "Eighty One", "Eighty Two", "Eighty Three", "Eighty Four", "Eighty Five", "Eighty Six", "Eighty Seven", "Eighty Eight", "Eighty Nine",
            "Ninety", "Ninety One", "Ninety Two", "Ninety Three", "Ninety Four", "Ninety Five", "Ninety Six", "Ninety Seven", "Ninety Eight", "Ninety Nine",
            "Hundred",
    };

    public static String numberToWords(int num) {
        if (num == 0) return "Zero";

        StringBuilder sb = new StringBuilder();

        int billion = (num / 1_000_000_000) % 1000;
        if (billion > 0) {
            sb.append(ENG_NUMBER[billion]).append(" Billion ");
        }

        int million = (num / 1_000_000) % 1000;
        if (million > 0) {
            if (million >= 100) sb.append(ENG_NUMBER[million / 100]).append(' ').append(ENG_NUMBER[100]).append(' ');
            if (million % 100 > 0) sb.append(ENG_NUMBER[million % 100]).append(' ');
            sb.append("Million ");
        }

        int thousand = (num / 1000) % 1000;
        if (thousand > 0) {
            if (thousand >= 100) sb.append(ENG_NUMBER[thousand / 100]).append(' ').append(ENG_NUMBER[100]).append(' ');
            if (thousand % 100 > 0) sb.append(ENG_NUMBER[thousand % 100]).append(' ');
            sb.append("Thousand ");
        }

        int ones = num % 1000;
        if (ones > 0) {
            if (ones >= 100) sb.append(ENG_NUMBER[ones / 100]).append(' ').append(ENG_NUMBER[100]).append(' ');
            if (ones % 100 > 0) sb.append(ENG_NUMBER[ones % 100]).append(' ');
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
