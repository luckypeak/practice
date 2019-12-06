/**
 * https://leetcode-cn.com/problems/water-and-jug-problem/
 * 365.水壶问题
 * 最大公约数 mx + ny = z
 * 假设最大公约数是 k 这 mx1+ ny1 = z/k
 *https://www.cnblogs.com/drizzlecrj/archive/2007/09/14/892340.html
 */
public class CanMeasureWater {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == z || y == z) {
            return true;
        }

        if (y > x) {
            int temp = y;
            y = x;
            x = temp;
        }
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return z % x == 0;
    }
}
