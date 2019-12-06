import common.TreeNode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/path-sum/submissions/
 * 路径总和
 * 1.递归，判断是否满足条件需要没有叶子节点，sum==0 并且 节点没有叶子节点才是终止条件
 */
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> cur_num = new Stack<>();
        stack.push(root);
        cur_num.push(sum - root.val);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int cur = cur_num.pop();
            if (cur == 0 && node.left == null && node.right == null) {
                return true;
            }
            if (node.left != null) {
                stack.push(node.left);
                cur_num.push(cur - node.left.val);
            }

            if (node.right != null) {
                stack.push(node.right);
                cur_num.push(cur - node.right.val);
            }
        }
        return false;
    }
}
