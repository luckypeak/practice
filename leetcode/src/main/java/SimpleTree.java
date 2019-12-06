import common.TreeNode;

public class SimpleTree {

    /**
     * https://leetcode-cn.com/problems/symmetric-tree/
     * 101.对称二叉树
     * 可以通过递归，bfs ，修改入队顺序，每次poll两个元素， 两个元素顺序应该一致
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricTree(root.left, root.right);
    }

    private boolean isSymmetricTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null) {
            return false;
        } else if (right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }
        boolean isLeft = isSymmetricTree(left.left, right.right);
        boolean isRight = isSymmetricTree(left.right, right.left);
        return isLeft && isRight;
    }
}
