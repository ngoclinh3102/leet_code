package logixtek.moitech.leetcode.practice;

public class L204 {

    public static void main(String[] args) {
        System.out.println(countPrimes(0));
        System.out.println(countPrimes(1));
        System.out.println(countPrimes(2));
        System.out.println(countPrimes(3));
        System.out.println(countPrimes(10));
        System.out.println(countPrimes(100));
    }

    public static int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] isPrime = new boolean[n];
        isPrime[0] = isPrime[1] = true;
        int counter = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                counter++;
                if (i*i < n) {
                    for (int j = i + i; j < n; j += i) {
                        isPrime[j] = true;
                    }
                }
            }
        }
        return counter;
    }
}
