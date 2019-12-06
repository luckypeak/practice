import common.TreeNode;

public class PathSum {

    /**
     * https://leetcode-cn.com/problems/path-sum-iii/
     * 437. 路径总和III
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return sum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int sum(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        int ans = 0;
        if (node.val == sum) {
            ans += 1;
        }
        ans += sum(node.left, sum - node.val);
        ans += sum(node.right, sum - node.val);
        return ans;
    }
}
