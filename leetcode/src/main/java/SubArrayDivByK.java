import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 * 和可被k整除的子数组
 * https://zh.wikipedia.org/wiki/%E5%AD%90%E9%9B%86%E5%92%8C%E5%95%8F%E9%A1%8C
 * 连续子数组时考虑前缀数组，使用P[i] 代表前i个元素的和
 * 考虑某段子数组A[i:j]%k==0 则一段p[j]%k - p[i] % k = 0, 即 p[j] %k = p[i] %k
 */
public class SubArrayDivByK {
    public int subarraysDivByK(int[] A, int K) {
        int len = A.length;
        if (len == 0) {
            return 0;
        }
        int[] p = new int[len];
        p[0] = A[0];
        for (int i = 1; i < len; i++) {
            p[i] = p[i - 1] + A[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        for (int n : p) {
            int val = (n % K + K) % K;
            int temp = map.getOrDefault(val, 0);
            ans += temp;
            map.put(val, temp + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        SubArrayDivByK subArrayDivByK = new SubArrayDivByK();
        int[] nums = new int[]{-2, -2, -2, -2, -2};
        System.out.println(subArrayDivByK.subarraysDivByK(nums, 5));
        System.out.println(Math.abs(-2%6));
        System.out.println((-2 % 6 + 6) % 6);
    }
}
