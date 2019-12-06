/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 最大子序和
 * 1.动态规划
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0 ;
        for (int num : nums){
            if (sum >  0 ){
                sum +=num;
            }else {
                sum = num;
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
