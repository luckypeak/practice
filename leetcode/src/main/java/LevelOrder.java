import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {



    private void  helper(TreeNode node, int level, List<List<Integer>> levels){
        if (levels.size() == level){
            List<Integer> temp = new ArrayList<>();
            levels.add(level, temp);
        }
        List<Integer> ans = levels.get(level);
        ans.add(node.val);
        if (node.left != null){
            helper(node.left, level +1, levels);
        }
        if (node.right != null){
            helper(node.right, level +1, levels);
        }
    }
    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        helper(root, 0, ans);
        return ans;
    }
    /**
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
     * 102. 二叉树的层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            List<TreeNode> nodes = new ArrayList<>();
            while (!queue.isEmpty()) {
                nodes.add(queue.poll());
            }
            for (TreeNode node : nodes) {
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }

    public static void main(String[] args) {
        LevelOrder levelOrder = new LevelOrder();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        levelOrder.levelOrder(root);
    }
}
