import java.util.*;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * 两个数组的交集 II
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 *  answer:  双指针， p1指向num1开头，p2指向num2 ， 相同是p1++， p2++， num1[p1]< num2[p2]时， p1++ ， num1[p1] ></>num2[p2]时， p2++
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 *
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *  使用磁盘排序，然后 map reduce
 */
public class IntersectArray {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int cnt = map.getOrDefault(num, 0) + 1;
            map.put(num, cnt);
        }
        for (int num : nums2) {
            int cnt = map.getOrDefault(num, 0);
            if (cnt==0) {
                continue;
            }
            cnt = cnt-1;
            map.put(num, cnt);
            ans.add(num);
        }
        int[] ansa = new int[ans.size()];
        int i =0 ;
        for (int num : ans){
            ansa[i++] = num;
        }
        return ansa;
    }
}
