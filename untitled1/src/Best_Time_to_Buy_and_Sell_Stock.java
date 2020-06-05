import java.util.HashMap;

public class Best_Time_to_Buy_and_Sell_Stock {
    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0 || prices.length == 1) return 0;
            HashMap<Integer, Integer> map = new HashMap();
            int min = Integer.MAX_VALUE;
            int maxprofit = 0;
            for (int i = 0; i < prices.length; i++) {
                min = Math.min(min, prices[i]);
                maxprofit = Math.max(maxprofit, prices[i] - min);
            }
            return maxprofit;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();
            int[] p = {7, 1, 5, 3, 6, 4};
            System.out.println(sol.maxProfit(p));
        }
    }}
