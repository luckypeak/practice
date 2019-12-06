import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * 530. 二叉搜索树的最小绝对差
 */
public class MinDiffInBST {
    TreeNode pre = null;
    int minRes = Integer.MAX_VALUE;
    void inOrder(TreeNode root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        if (pre != null){
            minRes = Math.min(minRes, Math.abs(pre.val-root.val));
        }
        pre = root;
        inOrder(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minRes;
    }
    public int minDiffInBST(TreeNode root) {
        List<Integer> nlist = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()){
                TreeNode t = stack.pop();
                nlist.add(t.val);
                node = t.right;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i< nlist.size() ; i++){
            min = Math.min(min, nlist.get(i) - nlist.get(i-1));
        }
        return min;
    }

}
