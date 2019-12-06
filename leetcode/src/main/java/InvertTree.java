import common.TreeNode;


public class InvertTree {


     public TreeNode invertTree(TreeNode root){
         if(root == null){
             return null;
         }
         TreeNode temp = root.right;
         root.right = root.left;
         root.left = temp;
         invertTree(root.left);
         invertTree(root.right);
         return root;
     }

    public static void main(String[] args) {

    }

}
