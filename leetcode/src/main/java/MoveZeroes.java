/**
 * https://leetcode-cn.com/problems/move-zeroes/
 * 283.移动零
 * 双指针: 注意不变换原来顺序
 * https://leetcode-cn.com/problems/move-zeroes/solution/yi-dong-ling-by-leetcode/
 */
public class MoveZeroes {

    public void moveZeros(int[] nums) {
        int zero = 0;
        int nonZero = 0;
        int n = nums.length;
        while (nonZero < n && zero < n) {
            if (nums[zero] == 0 && nums[nonZero] != 0) {
                swap(zero, nonZero, nums);
                zero++;
                nonZero++;
            } else if (nums[nonZero] == 0) {
                nonZero++;
            } else if (nums[zero] != 0) {
                zero++;
                nonZero++;
            }
        }
    }

    public void moveZeros2(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(i, k++, nums);
            }
        }
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 0};
        MoveZeroes mz = new MoveZeroes();
        mz.moveZeros(a);
        for (int num : a) {
            System.out.println(num);
        }
    }
}
