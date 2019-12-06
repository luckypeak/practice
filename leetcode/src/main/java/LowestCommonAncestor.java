import common.TreeNode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 236 二叉树的最近公共祖先
 */
public class LowestCommonAncestor {
    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return res;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        parents.put(root, null);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
                parents.put(node.left, node);
            }
            if (node.right != null) {
                stack.push(node.right);
                parents.put(node.right, node);
            }
        }

        Set<TreeNode> ancestor = new HashSet<>();
        while (p != null) {
            ancestor.add(p);
            p = parents.get(p);
        }

        while (!ancestor.contains(q)) {
            q = parents.get(q);
        }
        return q;
    }

    private boolean helper(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (currentNode == null) {
            return false;
        }
        int left = this.helper(currentNode.left, p, q) ? 1 : 0;
        int right = this.helper(currentNode.right, p, q) ? 1 : 0;
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;
        if (mid + left + right > 1) {
            this.res = currentNode;
        }
        return mid + left + right > 0;

    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(9);
        TreeNode q = new TreeNode(11);
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.left.left.left = new TreeNode(8);
        node.left.left.right = p;
        node.left.right.left = new TreeNode(10);
        node.left.right.right = q;
        new LowestCommonAncestor().lowestCommonAncestor(node, p, q);
    }
}
