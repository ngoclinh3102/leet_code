package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;

public class L188 {
    public static void main(String[] args) {

    }

    public int maxProfit(int k, int... prices) {
        int n = prices.length;
        ArrayList<Transaction> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            while (i + 1 < n && prices[i+1] <= prices[i]) {
                i++;
            }
            int j = i;
            while (i + 1 < n && prices[i+1] > prices[i]) {
                i++;
            }
            if (i > j) {
                list.add(Transaction.of(j, i, prices[i] - prices[j]));
            }
        }

        if (k >= list.size()) {
            int answer = 0;
            for (var t : list) {
                answer += t.profit;
            }
            return answer;
        }

        return -1;
    }

    static class Transaction {
        int buy;
        int sell;
        int profit;

        public Transaction(int buy, int sell, int profit) {
            this.buy = buy;
            this.sell = sell;
            this.profit = profit;
        };

        public static Transaction of(int buy, int sell, int profit) {
            return new Transaction(buy, sell, profit);
        }
    }
}
