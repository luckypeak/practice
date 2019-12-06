import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 重复元素
 */
public class ContainsDuplicate {
    /**
     * https://leetcode-cn.com/problems/contains-duplicate/
     * 217存在重复元素
     */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }
            int cnt = map.getOrDefault(num, 0) + 1;
            map.put(num, cnt);
        }
        return false;
    }

    /**
     * https://leetcode-cn.com/problems/contains-duplicate-ii/
     * 219.存在重复元素II
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearByDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean ans = false;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int preIndex = map.get(nums[i]);
                int diff = i - preIndex;
                if (diff <= k) {
                    return true;
                } else {
                    ans = false;
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return ans;

    }

    /**
     * https://leetcode-cn.com/problems/contains-duplicate-ii/
     * 219.存在重复元素II
     * https://leetcode-cn.com/problems/contains-duplicate-ii/solution/cun-zai-zhong-fu-yuan-su-ii-by-leetcode/
     * 主要思想维持一个大小为K 的窗口，然后在K的窗口中搜索
     * 可以使用大小为K滑动窗口， 大小为K的二叉搜索树， 大小为K 的hash set，逐步降低时间复杂度
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearByDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        boolean ans = false;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return ans;

    }

    /**
     * https://leetcode-cn.com/problems/contains-duplicate-iii/
     * 220. 存在重复元素III
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean ans = false;
        return ans;
    }
}
