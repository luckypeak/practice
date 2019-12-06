import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 * 另一个树的子树
 */
public class IsSubTree {

    /**
     * 递归判断，当某一级树节点相等时，要判断后续节点是否全部相等
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {

        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val) {
            return isEqual(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        } else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }

    private boolean isEqual(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val == node2.val) {
            return isEqual(node1.left, node2.left) && isEqual(node1.right, node2.right);
        }
        return false;
    }
}
