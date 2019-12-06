public class UnsortedSubarray {

    /**
     * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
     * 581. 最短无序连续子数组
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    r = Math.max(j, r);
                    l = Math.min(i, l);
                }
            }
        }
        return r - l < 0 ? -1 : r - l + 1;
    }

    public int findUnsortedSubarray2(int[] nums) {
        int l = nums.length, r = 0, beg = -1, end = -2, min = nums[l - 1], max = nums[0];
        for (int i = 1; i < l; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[l - i - 1]);
            if (nums[i] < max){
                end = i;
            }
            if(nums[l-i-1] > min){
                beg = l-i-1;
            }
        }

        return end - beg + 1;
    }
}
