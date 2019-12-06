import common.TreeNode;

public class LongestUnivaluePath {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null){
            return 0;
        }

        sameValuePath(root, root.val);
        return max;
    }

    public int sameValuePath(TreeNode root, int val) {
        if (root == null){
            return 0;
        }
        int left = sameValuePath(root.left, root.val);
        int right = sameValuePath(root.right, root.val);
        max = Math.max(max, left + right);
        if (root.val == val){
            return Math.max(left, right) + 1;
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
