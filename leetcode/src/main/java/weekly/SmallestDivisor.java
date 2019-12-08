package weekly;

import java.util.Arrays;

/**
 * @url https://leetcode-cn.com/problems/find-the-smallest-divisor-given-a-threshold/
 * @title 5281 使结果不超过阈值的最小除数
 * @tags 二分查找
 * 给你一个整数数组 nums 和一个正整数 threshold  ，你需要选择一个正整数作为除数，然后将数组里每个数都除以它，并对除法结果求和。
 *
 * 请你找出能够使上述结果小于等于阈值 threshold 的除数中 最小 的那个。
 *
 * 每个数除以除数后都向上取整，比方说 7/3 = 3 ， 10/2 = 5 。
 *
 * 题目保证一定有解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-smallest-divisor-given-a-threshold
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 除数的结果随除数的大小递减，所以除法结果的和在[1~10^6]的除数之间一定是有序，递减的，按照二分查找方法，寻找最接近的除数
 */
public class SmallestDivisor {

    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int low = 1, high = nums[nums.length-1];
        while (low <= high){
            int mid = (low+high)/2;
            int sum = calc(nums, mid);
            if (sum <= threshold){
                high = mid-1;
            }else {
                low = mid +1;
            }
        }
        return low;
    }

    private int calc(int[] nums, int div){
        int sum = 0;
        for (int i : nums){
            sum += i /div;
            if (i%div != 0){
                sum +=1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        SmallestDivisor smallestDivisor = new SmallestDivisor();
        int[] nums = new int[]{1,2,5,9};
        System.out.println("args = [" + smallestDivisor.smallestDivisor(nums, 6) + "]");
    }


}
