/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 寻找两个有序数组的中位数
 * <p>
 * 二分查找
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int length1 = nums1.length;
        int length2 = nums2.length;
        int iMin = 0, iMax = nums1.length;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (length1 + length2 + 1) / 2 - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else {
                int maxLeft;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((length1 + length2) % 2 == 1) { // 奇数返回left 值
                    return maxLeft;
                }
                int minRight;
                if (i == length1) {
                    minRight = nums2[j];
                } else if (j == length2) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }

        return 0.0f;
    }

    public static void main(String[] args) {
        FindMedianSortedArrays fms = new FindMedianSortedArrays();
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        System.out.println(fms.findMedianSortedArrays(nums1,nums2));
    }

}
