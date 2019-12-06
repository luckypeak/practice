package common;

public class TreeNode {
    public int val;
    public  TreeNode left;
    public  TreeNode right;
    public TreeNode (int x){
        val = x;
    }


    public TreeNode buildTreeNode(Integer []nums){
        TreeNode root = new TreeNode(nums[0]);
        TreeNode pre = root;
        for (int i = 1 ; i < nums.length; i++){
            if (nums[i] == null){
                continue;
            }
        }
        return root;
    }
}
