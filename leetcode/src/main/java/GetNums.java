/**
 * https://leetcode-cn.com/problems/sum-of-two-integers/
 * 位运算
 * 两整数之和
 */
public class GetNums {
    public int getSum(int a, int b) {
        if (b == 0){
            return a;
        }
        int m = a ^ b;
        int n = (a & b) << 1 ;
        return getSum(m, n);
    }

    public static void main(String[] args) {
        GetNums getNums = new GetNums();
        System.out.println(getNums.getSum(Integer.MAX_VALUE,1));
        System.out.println(Integer.MAX_VALUE+1);
        System.out.println(Integer.MAX_VALUE);
    }
}
