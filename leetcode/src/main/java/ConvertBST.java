import common.TreeNode;

import java.util.Stack;

public class ConvertBST {

    /**
     * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
     * 538. 二叉搜索数转换为累加树
     *
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            sum += node.val;
            node.val = sum;
            node = node.left;
        }
        return root;

    }

}

