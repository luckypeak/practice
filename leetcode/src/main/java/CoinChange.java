import java.lang.reflect.Array;
import java.util.Arrays;

public class CoinChange {

    /**
     * https://leetcode-cn.com/problems/coin-change/
     * 322. 零钱兑换
     * 回溯法
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        return coinChange2(coins, new int[amount], amount);
    }

    /**
     * https://leetcode-cn.com/problems/coin-change/
     * 322. 零钱兑换
     * 动态规划，自底向上
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] < i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * https://leetcode-cn.com/problems/coin-change/
     * 322. 零钱兑换
     * 动态规划，自顶向下
     *
     * @param coins
     * @param count
     * @param rem
     * @return
     */
    public int coinChange2(int[] coins, int[] count, int rem) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) { // 已经计算过了
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange2(coins, count, rem - coin);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        count[rem - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return count[rem - 1];
    }

    public int coinChange(int idx, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (idx < coins.length && amount > 0) {
            int maxVal = amount / coins[idx];
            int minCost = Integer.MAX_VALUE;
            for (int i = 0; i <= maxVal; i++) {
                if (amount >= i * coins[idx]) {
                    int res = coinChange(idx + 1, coins, amount - (i * coins[idx]));
                    if (res != -1) {
                        minCost = Math.min(minCost, res + i);
                    }
                }
            }
            return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
        }
        return -1;
    }

}
