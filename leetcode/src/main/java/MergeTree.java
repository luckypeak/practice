import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 * 617. 合并二叉树
 */
public class MergeTree {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null){
            return t2;
        }
        if (t2 == null){
            return t1;
        }
        TreeNode result = new TreeNode(t2.val + t1.val);
        result.left = mergeTrees(t1.left, t2.left);
        result.right = mergeTrees(t1.right, t2.right);

        return result;
    }

}
