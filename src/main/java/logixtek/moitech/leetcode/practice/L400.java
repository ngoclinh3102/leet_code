package logixtek.moitech.leetcode.practice;

public class L400 {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= 100; i++) builder.append(i);
        for (int i = 0; i < builder.length(); i++) System.out.print(builder.charAt(i)+ "\t"  +  (i + 1) + "\n");

        System.out.println(findNthDigit(8)); // 3
        System.out.println(findNthDigit(11)); // 0
        System.out.println(findNthDigit(184)); // 97 -> 9
        System.out.println(findNthDigit(132546)); // 8
        System.out.println(findNthDigit(2147483647)); // 2
    }

    public static int findNthDigit(int n) {
        if (n < 10) return n;
        int range = 9;
        int digits = 1;
        while (n / digits > range) {
            n -= range * digits;
            range *= 10;
            digits++;
        }
        String snumber = String.valueOf(range / 9 + (n - digits + 1) / digits);
        return snumber.charAt((n % digits > 0 ? n % digits : snumber.length()) - 1) - '0';
    }

    /*
    i   ni      n           f
    0   1       9           9 * 10^0
    1   2       90          9 * 10^1
    2   3       900         9 * 10^2
    */
    /*
    1	1
    2	2
    3	3
    4	4
    5	5
    6	6
    7	7
    8	8
    9	9
    1	10
    0	11
    1	12
    1	13
    1	14
    2	15
    1	16
    3	17
    1	18
    4	19
    1	20
    5	21
    1	22
    6	23
    1	24
    7	25
    1	26
    8	27
    1	28
    9	29
    2	30
    0	31
    2	32
    1	33
    2	34
    2	35
    2	36
    3	37
    2	38
    4	39
    2	40
    5	41
    2	42
    6	43
    2	44
    7	45
    2	46
    8	47
    2	48
    9	49
    3	50
    0	51
    3	52
    1	53
    3	54
    2	55
    3	56
    3	57
    3	58
    4	59
    3	60
    5	61
    3	62
    6	63
    3	64
    7	65
    3	66
    8	67
    3	68
    9	69
    4	70
    0	71
    4	72
    1	73
    4	74
    2	75
    4	76
    3	77
    4	78
    4	79
    4	80
    5	81
    4	82
    6	83
    4	84
    7	85
    4	86
    8	87
    4	88
    9	89
    5	90
    0	91
    5	92
    1	93
    5	94
    2	95
    5	96
    3	97
    5	98
    4	99
    5	100
    5	101
    5	102
    6	103
    5	104
    7	105
    5	106
    8	107
    5	108
    9	109
    6	110
    0	111
    6	112
    1	113
    6	114
    2	115
    6	116
    3	117
    6	118
    4	119
    6	120
    5	121
    6	122
    6	123
    6	124
    7	125
    6	126
    8	127
    6	128
    9	129
    7	130
    0	131
    7	132
    1	133
    7	134
    2	135
    7	136
    3	137
    7	138
    4	139
    7	140
    5	141
    7	142
    6	143
    7	144
    7	145
    7	146
    8	147
    7	148
    9	149
    8	150
    0	151
    8	152
    1	153
    8	154
    2	155
    8	156
    3	157
    8	158
    4	159
    8	160
    5	161
    8	162
    6	163
    8	164
    7	165
    8	166
    8	167
    8	168
    9	169
    9	170
    0	171
    9	172
    1	173
    9	174
    2	175
    9	176
    3	177
    9	178
    4	179
    9	180
    5	181
    9	182
    6	183
    9	184
    7	185
    9	186
    8	187
    9	188
    9	189
    1	190
    0	191
    0	192
    */
}
