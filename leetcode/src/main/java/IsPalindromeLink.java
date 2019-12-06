import common.ListNode;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * 回文链表
 */
public class IsPalindromeLink {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = null;
        ListNode cur = slow;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ListNode n1 = head;
        ListNode n2 = pre;
        while (n2 != null) {
            if (n1.val != n2.val) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        return true;

    }

    public static void main(String[] args) {
        IsPalindromeLink isPalindromeLink = new IsPalindromeLink();
        ListNode root = new ListNode(1);
        ListNode cur = root;
        for (int i = 2; i <= 8; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        System.out.println(isPalindromeLink.isPalindrome(root));
    }
}
