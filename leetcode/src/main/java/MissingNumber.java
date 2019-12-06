
public class MissingNumber {
    /**
     * https://leetcode-cn.com/problems/missing-number/
     * 268.缺失的数
     * 由于是连续的，值和索引异或
     */
    public int missingNumber268(int[] nums) {
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            ans ^= i ^ nums[i];
        }
        return ans;
    }

    /**
     * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int ans = 0;
        for (int i = 0 ; i < nums.length; i++){
            ans ^= nums[i] ^ i;
        }
        ans = ans ^ nums.length;

        return ans;
    }


}
