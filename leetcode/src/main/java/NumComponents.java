import common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/linked-list-components/
 * 817. 链表组件
 */
public class NumComponents {
    public int numComponents(ListNode head, int[] G) {
        int ans = 0;
        if (head == null) {
            return ans;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < G.length; i++) {
            map.put(G[i], i);
        }

        ListNode node = head;
        boolean isExist = false;
        while (node != null) {
            int cur = node.val;
            if (map.containsKey(cur) && !isExist) {
                ans++;
                isExist = true;
            } else if (!map.containsKey(cur)) {
                isExist = false;
            }
            node = node.next;
        }

        return ans;
    }
}
