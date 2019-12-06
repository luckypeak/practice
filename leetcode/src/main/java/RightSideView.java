import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

    public List<Integer> rightSideVide2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void  dfs(TreeNode node, int level, List<Integer> res){
        if (node == null){
            return;
        }
        if (res.size() == level){
            res.add(node.val);
        }
        dfs(node.right, level + 1, res);
        dfs(node.left, level + 1, res);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            TreeNode front = queue.peek();
            res.add(front.val);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (right != null) {
                    queue.add(right);
                }

                if (left != null) {
                    queue.add(left);
                }


            }


        }
        return res;
    }

    public static void main(String[] args) {
        RightSideView rv = new RightSideView();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(6);
        node.right = new TreeNode(3);
        System.out.println(rv.rightSideView(node));
    }
}
