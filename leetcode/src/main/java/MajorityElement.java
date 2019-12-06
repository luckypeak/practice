import java.util.List;

/**
 *
 */
public class MajorityElement {

    /**
     * https://leetcode-cn.com/problems/majority-element/
     * 169.求众数
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int cnt = 1;
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == result) {
                cnt++;
                if (cnt > nums.length / 2) {
                    return result;
                }
            } else {
                cnt--;
            }
            if (cnt <= 0) {
                result = nums[i];
                cnt = 1;
            }
        }

        return result;
    }

    private int getFirstIndex(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid+1;
            }
        }
        return left;
    }

    private int getLastIndex(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                left = mid+1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return right;
    }

    /**
     * https://leetcode-cn.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/
     * 1150. 检查一个数是否在数组中占绝大多数
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean isMajorityElement(int[] nums, int target) {
        int right = nums.length;
        int left = 0;
        int mid = (right + left) / 2;
        if (nums[mid] != target) {
            return false;
        }
        left = getFirstIndex(nums, left, mid, target);
        right = getLastIndex(nums, mid, right, target);
        return (right-left) > nums.length/2;
    }

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int[] nums = new int[]{10,100,101,101};
        System.out.print(me.isMajorityElement(nums, 101));
    }
}
