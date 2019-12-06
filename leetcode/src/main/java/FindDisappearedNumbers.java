import java.util.ArrayList;
import java.util.List;


public class FindDisappearedNumbers {

    /**
     * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
     * 448. 找到所有数组中消失的数字
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
    /**
     * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
     * 442. 数组中重复的数
     */
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        return ans;
    }
}
