import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 */
public class MergeKLists {

    /**
     * https://leetcode-cn.com/problems/merge-k-sorted-lists/
     * 23。合并k个排序链表
     *
     * @param list
     * @return
     */
    public ListNode mergeKLists(ListNode[] list) {
        if (list.length == 0) {
            return null;
        }
        ListNode pre = list[0];
        for (int i = 1; i < list.length; i++) {
            pre = merge(list[i], pre);
        }
        return pre;
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dumy = new ListNode(-1);
        ListNode result = dumy;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                result.next = new ListNode(node1.val);
                node1 = node1.next;
            } else {
                result.next = new ListNode(node2.val);
                node2 = node2.next;
            }
            result = result.next;
        }

        if (node1 != null) {
            result.next = node1;
        }
        if (node2 != null) {
            result.next = node2;
        }
        return dumy.next;
    }

    /**
     * 使用分治法，避免重复比较
     *
     * @param list
     * @return
     */
    public ListNode mergeKLists3(ListNode[] list) {
        if (list == null || list.length == 0) {
            return null;
        }
        return mergeDivide(list, 0, list.length - 1);
    }

    private ListNode mergeDivide(ListNode[] list, int left, int right) {
        if (left == right) {
            return list[left];
        }
        int mid = (right + left) / 2;
        ListNode l1 = mergeDivide(list, left, mid);
        ListNode l2 = mergeDivide(list, mid + 1, right);
        return merge(l1, l2);
    }

    /**
     * 维护一个大小位k小顶堆，堆顶总是最小的数
     *
     * @param list
     * @return
     */
    private ListNode mergeKLists2(ListNode[] list) {
        if (list == null || list.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode node : list) {
            if (node != null) {
                pq.add(node);
            }
        }
        ListNode dump = new ListNode(-1);
        ListNode result = dump;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.add(node.next);
            }
            result.next = node;
            result = result.next;
        }
        return dump.next;

    }

    public static void main(String[] args) {
        MergeKLists mergeKLists = new MergeKLists();
        ListNode root1 = new ListNode(1);
        ListNode root2 = new ListNode(2);
        ListNode node1 = root1;
        ListNode node2 = root2;
        for (int i = 0; i < 10; i++) {
            node1.next = new ListNode(i);
            node1 = node1.next;
        }
        for (int i = 3; i < 8; i++) {
            node2.next = new ListNode(i);
            node2 = node2.next;
        }

        mergeKLists.merge(root1, root2);
    }
}
