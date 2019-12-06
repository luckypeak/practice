/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 合并两个有序数组
 */
public class MereTwoNumbers {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n -1;
        for (; n > 0 && m > 0; ) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[length--] = nums1[m - 1];
                m--;
            } else {
                nums1[length--] = nums2[n - 1];
                n--;
            }
        }
        while (n > 0){
            nums1[length--] = nums2[--n];
        }
    }

    public static void main(String[] args) {
        MereTwoNumbers mt = new MereTwoNumbers();
        int[] n1 = new int[]{1};
        int[] n2 = new int[]{};
        mt.merge(n1,1,n2, 0);
        for (int n : n1){
            System.out.println(n);
        }
    }
}
