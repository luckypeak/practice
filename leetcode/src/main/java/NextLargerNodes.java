import common.ListNode;

import java.util.Stack;

/**
 * 单调栈
 */
public class NextLargerNodes {



    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        ListNode root1 = head;
        int length = 0;
        while (root1 != null){
            length ++;
            root1 = root1.next;
        }
        int[] result = new int[length];
        int[] result2 = new int[length];
        ListNode root2 = head;
        int j = 0;
        while (root2 != null){
            result2[j++] = root2.val;
            root2 = root2.next;
        }
        ListNode root = head;
        int i = 0;
        while (root != null){
            if (stack.size() == 0){
                stack.push(0);
            }
            while (!stack.isEmpty() && root.val > result2[stack.peek()]){
                result[stack.pop()] = root.val;
            }
            stack.push(i++);
            root = root.next;
        }

        return result;
    }
}
