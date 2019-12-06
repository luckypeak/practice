package weekly;


/**
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 */
public class CountSquares {


    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int len = Math.max(row, col);
        boolean[][][] dp = new boolean[row][col][len]; // 第row行， col 列 起点边长为 k 周围是否全为1
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j][0] = matrix[i][j] == 0;
                if (dp[i][j][0]) {
                    count++;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                for (int k = 1; k < len; k++) {
                    dp[i][j][k] = (matrix[i][j]== 1 && dp[i][j - 1][k - 1] && dp[i - 1][j - 1][k - 1] && dp[i - 1][j][k - 1]);
                    if (dp[i][j][k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
