import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 二叉树的直径
 */
public class DiameterOfBinaryTree {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }
        depth(root);
        return ans;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        ans = Math.max(left + right, ans);
        return Math.max(left, right) + 1;
    }
}
