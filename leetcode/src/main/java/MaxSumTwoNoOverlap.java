/***
 * @tags: 动态规划, 数组
 * @url: https://leetcode-cn.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
 * @title: 1031.两个非重叠子数组的最大和
 */
public class MaxSumTwoNoOverlap {

    /**
     * 计算子数组和时
     * @param A
     * @param L
     * @param M
     * @return
     */
    public int maxSumTwoNoOverLapWithDp(int[] A, int L , int M){
        int[] dp = new int[A.length];
        dp[0] = A[0];
        for (int i = 1 ; i < A.length ; i++){
            dp[i] = dp[i-1] + A[i];
        }
        int lMax = dp[L-1], mMax = dp[M-1], max = dp[L+M-1];
        for (int i = L+M; i < A.length; i++){
            lMax = Math.max(lMax, dp[i-M] - dp[i-M-L]);
            mMax = Math.max(mMax, dp[i-L] - dp[i-L-M]);
            max = Math.max(max, Math.max(lMax+ dp[i] - dp[i-M], mMax+ dp[i]- dp[i-L]));
        }
        return max;
    }

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int max = 0;

        for (int i = 0; i < A.length + 1 - L; i++) {
            for (int j = 0; j < A.length + 1 - M; j++) {
                int z = 0;
                if (!(j + M - 1 < i || j > i + L - 1)) { // 不能有重叠
                    continue;
                }
                for (int k = 0; k < L; k++) {
                    z += A[i + k];
                }
                for (int k = 0; k < M; k++) {
                    z += A[j + k];
                }
                max = max > z ? max : z;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSumTwoNoOverlap maxSumTwoNoOverlap = new MaxSumTwoNoOverlap();
        int[] arr = new int[]{3, 8, 1, 3, 2, 1, 8, 9, 0};
        System.out.println(maxSumTwoNoOverlap.maxSumTwoNoOverLapWithDp(arr, 3, 2));
    }
}
