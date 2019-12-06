import common.TreeNode;

public class LCA {


    /**
     * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
     * 235. 二叉搜索树 最近的公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //return dfs(root, p, q);
        TreeNode node = root;
        int pval = p.val;
        int qval = q.val;
        while (node != null) {
            if (pval < node.val && qval < node.val) {
                node = node.left;
            } else if (pval > node.val && qval > node.val) {
                node = node.right;
            } else {
                return node;
            }

        }
        return node;
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }
}
