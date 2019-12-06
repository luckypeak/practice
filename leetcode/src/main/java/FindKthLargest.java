import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 数组中的第k个最大元素
 */
public class FindKthLargest {

    /**
     *  第K个最大元素，优先级队列
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n));
        for (int n : nums){
            pq.add(n);
            if (pq.size() > k){
                pq.poll();
            }
        }

        return pq.poll();
    }


    public int findKthLargest2(int[] nums, int k){
        int ans = 0;
        return ans;
    }
}
