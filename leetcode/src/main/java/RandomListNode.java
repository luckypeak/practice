import common.ListNode;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/linked-list-random-node/
 * 链表随机节点
 * #tag  蓄水池抽样
 */
public class RandomListNode {

    private ListNode node;

    public RandomListNode(ListNode head) {
        node = head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        ListNode cur = this.node;
        ListNode res = cur;
        int i = 1;
        while (cur != null) {
            Random random = new Random();
            if (random.nextInt(i) == 0){
                res = cur;
            }
            cur = cur.next;
            i++;
        }
        return res.val;
    }

}
