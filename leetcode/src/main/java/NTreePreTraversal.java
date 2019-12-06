import java.util.*;

public class NTreePreTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) {
            return res;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            Collections.reverse(node.children);
            for (Node n : node.children) {
                stack.push(n);
            }
        }
        return res;
    }

    public List<Integer> preorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        preOreder(root, res);
        return res;
    }

    public void preOreder(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        for (Node n : node.children) {
            preOreder(n, res);
        }

    }
}
