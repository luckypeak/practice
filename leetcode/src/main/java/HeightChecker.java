import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/height-checker/
 * 1051.高度检查器
 */
public class HeightChecker {

    public int heightChecker(int[] heights) {
        int ans = 0;
        int[] nh = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);
        for (int i = 0; i < nh.length; i++) {
            if (heights[i] != nh[i]) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 计数排序
     *
     * @param heights
     * @return
     */
    public int heightChecker2(int[] heights) {
        int ans = 0;
        int[] count = new int[101];
        for (int height : heights) {
            count[height]++;
        }
        for (int i = 0, j = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                if (i != heights[j++]) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
