import common.ListNode;

/**
 *
 * https://www.cnblogs.com/grandyang/p/4306611.html
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 反转链表2
 * 首先循环到m节点开始 反转，反转过程中每次循环的节点都是放到pre 后面
 * 1.
 *   1->2->3->4->5
 *   1->3->2->4->5
 *   1->4->3->2->5
 *
 */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode pre = dump;
        for (int i = 1; i<m;i++){
            pre =pre.next;
        }

        ListNode cur = pre.next;
        for (; m < n; m++){
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dump.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ReverseBetween rl = new ReverseBetween();

        ListNode cur = root;
        for (int i = 2; i <= 1; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode node = rl.reverseBetween(root, 1, 1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

}
