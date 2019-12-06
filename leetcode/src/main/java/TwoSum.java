import java.util.*;

public class TwoSum {

    /**
     * https://leetcode-cn.com/problems/two-sum/
     * 两数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] targetArr = new int[2];
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int source = nums[i];
            if (numMap.containsKey(nums[i])) {
                targetArr[0] = numMap.get(nums[i]);
                targetArr[1] = i;
                return targetArr;
            }
            numMap.put(target - source, i);
        }
        return targetArr;
    }

    /**
     * 15.三数之和
     * https://leetcode-cn.com/problems/3sum/
     * 排序后使用双指针，一个从前，一个从后，注意相同的值要一直跳过，因为不允许出现相同的序列
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length == 0 || nums[0] > 0) {
            return ans;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
            while (lo < hi) {
                int s = nums[lo] + nums[hi];
                if (s == sum) {
                    ans.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo] == nums[++lo]) ;
                    while (lo < hi && nums[hi] == nums[--hi]) ;
                } else if (s < sum) {
                    while (lo < hi && nums[lo] == nums[++lo]) ;
                } else {
                    while (lo < hi && nums[hi] == nums[--hi]) ;
                }
            }
        }
        return ans;

    }

    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int ans = target;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi] + nums[i];
                int s = sum-target;
                if (Math.abs(s) < diff){
                    ans  =  sum;
                    diff = Math.abs(s);
                }
                if (s == 0) {
                    return target;
                } else if (s < 0) {
                    while (lo < hi && nums[lo] == nums[++lo]) ;
                } else {
                    while (lo < hi && nums[hi] == nums[--hi]) ;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {0,2,1,-3};
        System.out.println(new TwoSum().threeSumClosest(nums, 1));

    }
}
