import common.ListNode;


/**
 * https://leetcode-cn.com/problems/reverse-linked-list/submissions/
 * 反转链表
 * 递归
 * 迭代
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ReverseList rl = new ReverseList();

        ListNode cur = root;
        for (int i = 2; i <= 8; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode node = rl.reverseList2(root);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }


}
