import java.util.HashMap;

public class Coin_Change {
    static class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) return 0;
            int[] count = new int[amount + 1];
            count[0] = 0;
            for (int i = 1; i <= amount; i++){count[i] = amount+1;}
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (i-coin>=0&&count[i-coin]+1<count[i]) count[i] = count[i-coin]+1;
                }
            }
            if(count[amount]==amount+1) return -1;
            else return count[amount];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.coinChange(new int[]{1,2,5}, 11));
    }
}
