/**
 * https://leetcode-cn.com/problems/plus-one/
 * 66.加一
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + 1;
            if (digits[i] < 10) {
                return digits;
            } else {
                digits[i] = digits[i] % 10;
            }
        }
        int[] ans = new int[digits.length +1];
        ans[0] = 1;
        return ans;
    }
}
