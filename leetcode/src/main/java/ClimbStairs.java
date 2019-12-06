/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 爬楼梯
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        int[] sum = new int[n+1];
        sum[1] = 1;
        sum[0] = 1;
        for (int i = 2; i <= n; i++) {
            sum[i] = sum[i - 1] + sum[i - 2];
        }
        return sum[n];
    }


}
