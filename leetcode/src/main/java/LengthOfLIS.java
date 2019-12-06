/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 最长上升子序列
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int ans;
        int pre;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = 1;
            pre = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] > pre) {
                    pre = nums[j];
                    ans++;

                }
            }
            max = Math.max(ans, max);
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLIS ll = new LengthOfLIS();
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(ll.lengthOfLIS(nums));
    }
}
