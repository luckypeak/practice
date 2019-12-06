import common.TreeNode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-search/
 * 二分查找
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        int mid;
        while (left <= right) {
            mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    /**
     * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
     * 852. 闪粉数组的峰顶索引
     *
     * @param A
     * @return
     */
    public int peakIndexInMountainArray(int[] A) {
        int ans = -1;
        int left = 0;
        int right = A.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    /**
     * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
     * 230. 二叉搜索树中第K小的元素
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }

    /**
     * https://leetcode-cn.com/problems/intersection-of-two-arrays/
     * 349. 两个数组的交集
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int n : nums2) {
            set2.add(n);
        }
        set1.retainAll(set2);
        int[] ans = new int[set1.size()];
        int idx = 0;
        for (int i : set1) {
            ans[idx++] = i;
        }

        return ans;
    }

    /**
     * https://leetcode-cn.com/problems/divide-two-integers/
     * 29. 两数相除
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && Math.abs(divisor) == 1) {
            return divisor == -1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        int ans = 0;
        int divisor1 = Math.abs(divisor);
        int dividend1 = Math.abs(dividend);
        if (dividend1 < divisor1) {
            return 0;
        }
        int d1 = 0, count = 0 ;
        while (divisor1 <= dividend1) {
            count = 1;
            d1 = divisor1;
            while (d1 + d1 <= dividend1){
                d1 +=d1;
                count += count;
            }
            dividend1 -= d1;
            ans = ans + count;
        }

        return dividend < 0 ^ divisor < 0 ? -1 * ans : ans;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        bs.divide(7, -2);
    }

}
