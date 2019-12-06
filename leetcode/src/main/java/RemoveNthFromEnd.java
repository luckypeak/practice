import common.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 删除链表的倒数第N个节点
 */
public class RemoveNthFromEnd {

    /**
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode kNode = head;
        ListNode pre = dummy;
        for (int i = 0; i < n; i++) {
            kNode = kNode.next;
        }

        while (kNode != null) {
            kNode = kNode.next;
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        int[] ar = new int[]{2, 3, 4, 5};
        ListNode pre = root;
        for (int i : ar) {
            ListNode node = new ListNode(i);
            pre.next = node;
            pre = node;
        }
        RemoveNthFromEnd re = new RemoveNthFromEnd();
        re.removeNthFromEnd(root, 2);
    }
}
