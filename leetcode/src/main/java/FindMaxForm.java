import java.util.Arrays;

public class FindMaxForm {

    /**
     * https://leetcode-cn.com/problems/ones-and-zeroes/
     * 474。 一和零
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */

    int[][][] memo;

    public int findMaxForm(String[] strs, int m, int n) {
        memo = new int[strs.length][m + 1][n + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return tryFindMaxForm2(strs, strs.length - 1, m, n);
    }

    private int tryFindMaxForm(String[] strs, int i, int m, int n) {
        if (i < 0) {
            return 0;
        }
        int num0 = 0, num1 = 0;
        for (int j = 0; j < strs[i].length(); j++) {
            if (strs[i].charAt(j) == '0') {
                num0++;
            } else {
                num1++;
            }
        }
        if (m >= num0 && n >= num1) {
            return Math.max(tryFindMaxForm(strs, i - 1, m - num0, n - num1) + 1, tryFindMaxForm(strs, i - 1, m, n));
        } else {
            return tryFindMaxForm(strs, i - 1, m, n);
        }
    }

    private int tryFindMaxForm2(String[] strs, int i, int m, int n) {
        if (i < 0) {
            return 0;
        }

        if (memo[i][m][n] != -1) {
            return memo[i][m][n];
        }
        int num0 = 0, num1 = 0;
        for (int j = 0; j < strs[i].length(); j++) {
            if (strs[i].charAt(j) == '0') {
                num0++;
            } else {
                num1++;
            }
        }
        if (m >= num0 && n >= num1) {
            memo[i][m][n] = Math.max(tryFindMaxForm(strs, i - 1, m - num0, n - num1) + 1, tryFindMaxForm(strs, i - 1, m, n));
        } else {
            memo[i][m][n] = tryFindMaxForm(strs, i - 1, m, n);
        }
        return memo[i][m][n];
    }

    /**
     * 动态规划
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm2(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < strs.length; i++) {
            int num0 = 0, num1 = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') {
                    num0++;
                } else {
                    num1++;
                }

            }
            for (int j = m; j >= num0; j--) {
                for (int k = n; k >= num1; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - num0][k - num1] + 1);
                }
            }
        }

        return dp[m][n];
    }

}
