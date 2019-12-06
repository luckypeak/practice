import common.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int carry = 0;
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        while (head1 != null || head2 != null){
               int headval1 = head1 == null ? 0 : head1.val;
               int headval2 = head2 == null ? 0 : head2.val;
               int sum = headval1+ headval2 + carry;
               carry = 0;
               if (sum >= 10){
                   carry = 1;
                   sum = sum % 10;
               }
               temp.next = new ListNode(sum);
               temp = temp.next;
               head1 = head1 != null ? head1.next : null;
               head2 = head2 != null ? head2.next : null;
        }

        if (carry > 0){
            temp.next = new ListNode(1);
        }


        return newHead.next;
    }

    public static void main(String[] args) {
        int a[] = {};
        int b[] = {5,6,4};
        ListNode aNode = new ListNode(0);
        ListNode temp = aNode;
        for (int i : a){
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        ListNode bNode = new ListNode(0);
        temp = bNode;
        for (int i : b){
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        ListNode n1 = new AddTwoNumbers().addTwoNumbers(aNode.next, bNode.next);
        System.out.println(n1.val);

    }


}
