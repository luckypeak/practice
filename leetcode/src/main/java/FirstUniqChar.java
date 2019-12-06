import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * 字符串中的第一个唯一字符
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        int ans = -1;
        char[] cs = s.toCharArray();
        int[] cnt = new int[26];
        for (int i = 0; i < cs.length; i++) {
            cnt[cs[i] - 'a']++;
        }
        for (int i = 0; i < cs.length; i++) {
            if (cnt[cs[i] - 'a']==1){
                return i;
            }
        }
        return ans;
    }
}
