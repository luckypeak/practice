import common.TreeNode;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class FindSecondMinimumValue {

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int min = root.val;
        int smin = root.val;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val > min) {
                if (smin == min) {
                    smin = node.val;
                } else if (node.val < smin) {
                    smin = node.val;
                }
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        if (min == smin) {
            return -1;
        }
        return smin;
    }

    public int findKMinimumValue(TreeNode root) {

        return -1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;
        System.out.println(new FindSecondMinimumValue().findSecondMinimumValue(root));
    }
}
