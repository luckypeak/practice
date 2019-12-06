import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/house-robber/
 * 198 打家劫舍
 */
public class Rob {
    public int rob2(int[] nums) {
        int curmax = 0;
        int premax = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = curmax;
            curmax = Math.max(premax + nums[i], curmax);
            premax = temp;
        }

        return curmax;
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[nums.length];

    }


    /**
     * https://leetcode-cn.com/problems/house-robber-ii/
     * 213. 打家劫舍II
     * 不偷第一家和最后一家
     *
     * @param nums
     * @return
     */
    public int rob3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length + 1];
        dp1[0] = 0;
        dp1[1] = nums[0];
        for (int i = 2; i <= nums.length - 1; i++) {// 不偷最后一家
            dp1[i] = Math.max(dp1[i - 2] + nums[i - 1], dp1[i - 1]);
        }
        for (int i = 2; i <= nums.length; i++) { // 不偷第一家
            dp2[i] = Math.max(dp2[i - 2] + nums[i - 1], dp2[i - 1]);
        }
        return Math.max(dp1[nums.length - 1], dp2[nums.length]);
    }

    /**
     * https://leetcode-cn.com/problems/house-robber-iii/
     * 337.打家劫舍III
     *
     * @param root
     * @return
     */
    public int rob3(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return ans;
        }
       int[] res = doRob(root);
       return Math.max(res[0], res[1]);
    }


    public int[] doRob(TreeNode root){
        int[] res = new int[2]; //分别代表包含根结点和不包含根结点，递归
        if (root == null){
            return res;
        }
        int[] left = doRob(root.left);
        int[] right = doRob(root.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // 不包含根结点，左右子节点最大值的和
        res[1] = left[0]  + right[0] + root.val; // 包含根结点，前序节点不能包含根节点
        return res;
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        int[] a = new int[]{1, 2, 3, 1};
        rob.rob(a);
    }


}
