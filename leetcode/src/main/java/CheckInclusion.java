/**
 * https://leetcode-cn.com/problems/permutation-in-string/
 * 滑动窗口
 * https://blog.csdn.net/sty945/article/details/79846516
 */
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() < s1.length()){
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0 ; i< s1.length(); i ++){
            count1[s1.charAt(i) - 'a'] ++;
            count2[s2.charAt(i) - 'a'] ++;
        }
        for (int i = s1.length() ; i < s2.length(); i ++){
            if (isSame(count1, count2)){
                return true;
            }
            count2[s2.charAt(i-s1.length()) - 'c'] --;
            count2[s2.charAt(i) - 'c'] ++;
        }
        return isSame(count1, count2);
    }


    boolean isSame(int[] count1, int[] count2) {
        for (int i = 0; i < count1.length; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckInclusion ci = new CheckInclusion();
        System.out.println(ci.checkInclusion("ab", "eidboaooo"));
    }

}
