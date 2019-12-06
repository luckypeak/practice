import common.ListNode;

public class MergeSortList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode head = new ListNode(-1);
        ListNode dump = head;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                head.next = new ListNode(head1.val);
                head1 = head1.next;
            } else {
                head.next = new ListNode(head2.val);
                head2 = head2.next;
            }
            head = head.next;
        }

        if (head2 != null) {
            head.next = head2;
        } else {
            head.next = head1;
        }

        return dump.next;

    }

}
