import common.ListNode;

public class DeleteDuplicatesNode {


    /**
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
     * 删除排序链表中的重复元素
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = head;
        while (node != null) {
            if (node.next != null && node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dump = new ListNode(0 == head.val ? 1 : 0);
        ListNode pre = dump;
        ListNode cur = head;
        dump.next = head;
        ListNode first = dump;
        while (cur != null && cur.next != null) {
            if (pre.val != cur.val && cur.val != cur.next.val){
                first.next = cur;
                first = first.next;
            }
            pre = cur;
            cur = cur.next;
        }
        if (pre.val != cur.val){
            first.next = cur;
            first = first.next;
        }
        first.next = null;
        return dump.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        int[] ar = new int[]{1, 1, 2, 3};
        ListNode pre = root;
        for (int i : ar) {
            ListNode node = new ListNode(i);
            pre.next = node;
            pre = node;
        }

        DeleteDuplicatesNode dn = new DeleteDuplicatesNode();
        dn.deleteDuplicates2(root);
    }
}
