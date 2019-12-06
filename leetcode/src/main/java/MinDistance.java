public class MinDistance {

    /**
     * 72. 编辑距离
     * https://leetcode-cn.com/problems/edit-distance/
     *
     * @param word1
     * @param word2
     * @return
     * @tags 动态规划
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 != null) {
            return word2.length();
        }
        if (word2 == null && word1 != null) {
            return word1.length();
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {

                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    /**
     * 161.相隔为1的编辑距离
     * https://leetcode-cn.com/problems/one-edit-distance/
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isOneEditDistance(String s, String t) {
        boolean res = false;
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        int min = Math.min(s.length(), t.length());
        int dif = 0;
        for (int i = 0, j = 0; i < s.length() && j < t.length(); ) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                continue;
            }else {
                dif ++;
            }
        }
        return res;
    }
}
