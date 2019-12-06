import java.util.Arrays;

public class LongestCommonSubsequence {

    /**
     * https://leetcode-cn.com/problems/longest-common-subsequence/
     * 1143.最长公共子序列
     * 动态规划，找到状态转移方程
     * 1. 当text1[i] == text2[j] 时 dp[i][j] = dp[i-1][j-1] + 1
     * 否则 取 Math.max(dp[i - 1][j], dp[j][i - 1]) 最大值
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {

            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    /**
     * https://leetcode-cn.com/problems/longest-increasing-subsequence/
     * 300.最长上升子序列
     * 动态规划： 划分子问题，都第i个元素的最长上升子序列, 所以两层循环 j < i , 如果dp[i]
     * 状态转移方程: dp[i] = dp[j]+1 for j < i if num[j] < num[i]
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        int maxAns = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxAns = Math.max(dp[i], maxAns);

        }
        return maxAns;
    }

    /**
     * 利用dp 数组的递增性 和 二分查找
     * 假设一个上升序列，前面一个数越小，递增可能性越大。维持一个数组 tail 递增，遍历原始数组num，查找 num[i] 在 tail数组插入点，
     * 如果插入点是最后位置，则递增。
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int[] tail = new int[nums.length];
        int tailIndex = 0;
        for (int i = 0 ; i < nums.length; i++){
            int index = Arrays.binarySearch(tail, 0, tailIndex, nums[i]);
            if (index < 0){
                index = -(index + 1);
            }
            tail[index] = nums[i];
            if(index == tailIndex){
                tailIndex++;
            }

        }
        return tailIndex;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        longestCommonSubsequence.longestCommonSubsequence("abcde", "ace");
        int[] nums = {10,9,2,5,3,7,101,18};
        longestCommonSubsequence.lengthOfLIS2(nums);
    }

}
