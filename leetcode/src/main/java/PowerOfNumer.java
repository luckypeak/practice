/**
 * https://leetcode-cn.com/problems/power-of-three/
 * 326. 3的幂
 * https://leetcode-cn.com/problems/power-of-three/solution/3de-mi-by-leetcode/
 */
public class PowerOfNumer {

    public boolean isPowerOfThree(int n) {
        return isPowerOfNumber(n, 3);
    }

    public boolean isPowerOfNumber(int n, int num) {
        if (n < 1) {
            return false;
        }
        while (n % num == 0) {
            n = n / num;
        }
        return n == 1;
    }
}
