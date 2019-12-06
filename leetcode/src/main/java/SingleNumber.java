public class SingleNumber {

    /**
     * https://leetcode-cn.com/problems/single-number/submissions/
     * 只出现一次的数字
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    /**
     * 137 只出现一次的数字
     * https://leetcode-cn.com/problems/single-number-ii/
     * 设置三个变量 one ， two， there 分别代表出现一次，两次，三次
     * 出现一次不停异或，最后只会保留出现一次数的位
     * 出现两次 通过 出现一次的one 与当前 数 且操作，如果出现两次则对应位都是1 ，保留对应位都是1，如果仅出现一次则 one 变量会为0
     * 通过one 与 two 且运算，使出现三次的位全部为1，并且重置 one 和two。
     * @param nums
     * @return
     */
    public int signleNumber2(int[] nums) {
        int one = 0, two = 0, there = 0;
        for (int i : nums) {
            two |= one & i;
            one = one ^ i;
            there = one & two;
            one = one & ~there;
            two = two & ~there;

        }
        return one;
    }

    /**
     * https://leetcode-cn.com/problems/single-number-iii/
     * 260. 只出现一次的数字
     * 思路： 首先一次异或最后得到的数时 两个出现一次的数的异或结果 比如 1,2,2,1,3,5 异或结果 011, 101， 异或的 110。
     * 对于某一个非0位，必然不重复的两个数中一个为0，一个非0。 取某一个非0位将数组分成两个，分别对两个数组异或
     * 通过 temp  & (-temp) , -temp等于 temp 取反加1，再与原值企且运算找到最右的0
     *
     * @param nums
     * @return
     */
    public int[] singleNumber3(int[] nums) {
        int[] ans = new int[2];
        int temp = 0;
        for (int i : nums) {
            temp = temp ^ i;
        }

        temp = temp & (-temp);
        for (int i : nums) {
            if ((temp & i) == 0) {
                ans[0] ^= i;
            } else {
                ans[1] ^= i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber3(new int[]{2, 1, 1, 2, 3, 5}));
    }
}
