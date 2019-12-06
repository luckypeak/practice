public class Palindrome {

    int max = 0;
    int lo = 0;

    /**
     * https://leetcode-cn.com/problems/palindrome-number/
     * 9. 回文数
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        String st = String.valueOf(x);
        int mid = st.length() / 2;
        for (int i = 0; i < mid; i++) {
            if (st.charAt(i) != st.charAt(st.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 反转字符串，同时当反转后的字符串大于原始字符串时，代表已经进行一半
     *
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x = x / 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }

    /**
     * https://leetcode-cn.com/problems/longest-palindromic-substring/
     * 5.最长回文子串
     * 题解：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode/
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int max = 0;
        String ans = s;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if (isPalindrome(temp) && temp.length() > max) {
                    ans = temp;
                    max = temp.length();
                }
            }
        }
        return ans;

    }

    /**
     * 动态规划： 两次循环避免中间的计算
     *
     * @param s
     * @return
     */
    public String longestPalindrome6(String s) {
        String res = "";
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                // 如果 j-i 代表窗口小于等于2，必然满足条件。相当于初始化
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 3 || dp[i + 1][j - 1] );
                if (dp[i][j] && res.length() < (j - i + 1)) {
                    res = s.substring(i, j+1);
                }
            }
        }

        return res;
    }

    /*
      判断最长回文字符串： 从中心往外扩展，找到最大的
     */
    public String longestPalindrome5(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(lo, lo + max);

    }

    private void extendPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (j - i - 1 > max) {
            lo = i + 1;
            max = j - i - 1;
        }
    }


    private boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String s = "assaas";
        System.out.println(s.substring(1, s.length()));
        Palindrome palindrome = new Palindrome();
        palindrome.longestPalindrome6("babad");
    }
}
