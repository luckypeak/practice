import java.util.Arrays;

public class Primes {

    /**
     * 204.计算质数
     * https://leetcode-cn.com/problems/count-primes/
     *
     * @param n
     * @return
     */
    public int countPrimes2(int n) {
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public int countPrimes(int n) {
        int cnt = 0;
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);
        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) { // 素数筛选法，如果i是素数，则i的倍数一定不是素数
                for (int j = i + i; j < n; j += i) {
                    isPrimes[j] = false;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean isPrimes(int n) {
        int i = 2;
        while (i <= Math.sqrt(n)) {
            if (n % i == 0) {
                return false;
            }
            i++;
        }
        return true;

    }

    public static void main(String[] args) {
        Primes primes = new Primes();
        System.out.print(primes.countPrimes(10));
    }
}
