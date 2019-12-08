package weekly;


/**
 * @url https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 * @title 5279.整数的各位积和之差
 */
public class SubtractProductAndSum {

    public int subtractProductAndSum(int n) {
        if (n == 0) {
            return n;
        }
        int mSum = 1, sum = 0;
        while (n != 0 ){
            int temp = n %10;
            mSum *= temp;
            sum += temp;
            n = n/10;
        }
        return mSum-sum;
    }

    public static void main(String[] args) {
        SubtractProductAndSum subtractProductAndSum = new SubtractProductAndSum();
        System.out.println("args = [" + subtractProductAndSum.subtractProductAndSum(-234) + "]");

    }
}
