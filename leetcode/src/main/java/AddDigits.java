/**
 * https://leetcode-cn.com/problems/add-digits/
 * 各位相加
 * 设 三个数abc，最终结果是  a+b+c , abc=100*a+10*b+c
 * 两者查找 abc - (a+b+c) = 99a+9b
 */
public class AddDigits {
    public int addDigits(int num) {
        if (num==0){
            return 0;
        }
        int res = num % 9;
        return res == 0 ? 9 : res;

    }
}
