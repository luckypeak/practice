/**
 * https://leetcode-cn.com/problems/reverse-string/
 * 344： 反转字符串
 * 思路:
 * 1.原地反转，两个指针分别指向头和尾
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int i = 0;
        int n = s.length - 1;
        while (i < n){
            char temp = s[i];
            s[i] = s[n];
            s[n] = temp;
            i++;
            n--;
        }
    }

}
