import java.util.Arrays;

public class BagOfToken {

    /**
     * https://leetcode-cn.com/problems/bag-of-tokens/
     * 948. 令牌放置
     * 算法: 贪心算法
     * 思路: 尽可能的减少能量时小，增加能量时大。排序数组，从left 减能量，从right 加能量。 注意判断边界和能量P的关系
     *
     * @param tokens
     * @param P
     * @return
     */
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int ans = 0, point = 0;
        int lo = 0, high = tokens.length - 1;
        while (lo <= high && (P > tokens[lo] || point > 0)) {
            while (lo <= high && tokens[lo] <= P) {
                point++;
                P -= tokens[lo++];
            }
            ans = Math.max(point, ans);
            if (lo <= high && point > 0) {
                P += tokens[high--];
                point--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        BagOfToken bagOfToken = new BagOfToken();
        int[] token = new int[]{100, 200};
        bagOfToken.bagOfTokensScore(token, 50);
    }

}
