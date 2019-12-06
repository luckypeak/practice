
public class MaxProfit {

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/submissions/
     * 买卖股票的最佳时机
     * 遍历维护一个最小的买入值，后续动态更新最大值
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
        }
        return maxProfit;
    }

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     * 122. 买卖股票的最佳时机 II
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        return maxProfit;
    }

}
