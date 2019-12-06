import common.ListNode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BST {
    /**
     * https://leetcode-cn.com/problems/validate-binary-search-tree/
     *
     * @param root
     * @return
     */
    public boolean isValid(TreeNode root) {
        if (root == null) {
            return true;
        }
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        return isValid(root, max, min);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            ans.add(cur.val);
            cur = cur.right;
        }
        return ans;
    }

    public boolean isValidByTraversal(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        long preVal = Long.MIN_VALUE;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (preVal >= cur.val) {
                return false;
            }
            preVal = cur.val;
            cur = cur.right;
        }
        return true;
    }

    private boolean isValid(TreeNode root, long max, long min) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        if (!isValid(root.right, max, root.val)) {
            return false;
        }
        if (!isValid(root.left, root.val, min)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        TreeNode newNode = new TreeNode(15);
        root.right = newNode;
        newNode.left = new TreeNode(6);
        newNode.right = new TreeNode(20);
        List<Integer> ans = bst.inorderTraversal(root);

        System.out.println(bst.isValidByTraversal(root));
        System.out.println(bst.isValid(root));
    }
}
