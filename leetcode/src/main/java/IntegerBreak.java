/**
 * https://leetcode-cn.com/problems/integer-break/
 * 323 整数拆分
 */
public class IntegerBreak {

    int[] memory;
    public int integerBreak(int n) {
        int ans = 0;
        memory = new int[n+1];
        integerHelper(n);
        return memory[n];
    }

    public  int integerBreak3(int n){
        memory = new int[n+1];
        memory[0] = 1;
        memory[1] = 1;
        for (int i = 2; i< n; i++){
            int maxValue = 0;
            for (int j = 1; j < i ; j++){
                maxValue = Math.max(maxValue, Math.max(j * (i-j) , j * memory[i-j]));
            }
            memory[i] = maxValue;
        }
        return memory[n];
    }
    public int integerHelper(int n){
        if (n == 2){
            memory[n]= 1;
            return 1;
        }
        if (memory[n] != 0){
            return memory[n];
        }
        int res = 0;
        for (int i = 1; i< n; i++){
            res = Math.max(res, Math.max(i * integerHelper(n-i), i * (n-i)));
        }
        memory[n] = res;
        return res;
    }

}
