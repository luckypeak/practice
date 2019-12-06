import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的完全性校验
 * https://baike.baidu.com/item/%E5%AE%8C%E5%85%A8%E4%BA%8C%E5%8F%89%E6%A0%91/7773232?fr=aladdin
 * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/submissions/
 * 1.如果是空二叉树返回false
 * 2. 如果二叉树的左子树不为空，右子树为空返回false
 * 3. 如果二叉树右树已经为空，左树不能再有子节点
 * 通过层序遍历，分别判断每一层是否满足条件
 */
public class CompleteTree {


    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while (queue.size() != 0) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left == null && right != null || flag && left != null) {
                return false;
            }

            if (left != null) {
                queue.offer(left);
            }

            if (right != null) {
                queue.offer(right);
            } else {
                flag = true;
            }
        }
        return true;
    }



}
