/**
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 * N叉树最大深度
 */
public class NTreeMaxDepth {

    public int maxDepth(Node root) {
        if (root == null){
            return 0;
        }
        int ans = 0;

        for (Node children :  root.children){
            ans = Math.max(ans, maxDepth(children)) ;
        }
        return ans + 1;
    }

}
