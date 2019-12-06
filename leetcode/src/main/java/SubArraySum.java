import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * 和为K的子数组
 */
public class SubArraySum {

    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        int len = nums.length;
        int[] p = new int[len + 1];
        for (int i = 0; i < len; i++) {
            p[i + 1] = p[i] + nums[i];
        }
        for (int i = 0; i < p.length - 1; i++) {
            for (int j = i + 1; j < p.length; j++) {
                if (p[j] - p[i] == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public int subarraySum2(int[] nums, int k) {
        int cnt = 0;
        int sum = 0;
        Map<Integer, Integer> p = new HashMap<>();
        p.put(0, 1);
        for (int num : nums) {
            sum += num;
            int temp = p.getOrDefault(sum, 0);
            cnt += p.getOrDefault(sum - k, 0);
            p.put(sum, temp+1);

        }
        return cnt;
    }
}
