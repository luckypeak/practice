import java.util.Stack;

public class EncodedString {

    /**
     * 394. 字符串编码
     * https://leetcode-cn.com/problems/decode-string/
     * 递归利用栈 后进先出
     * 两种结构:
     * 3[a]2[b]
     * 3[a2[b]]
     * 遍历字符串，当遇到] 代表一次字符串的结束
     * 维护两个栈，cntStack，strStack. cnt 代表当前字符串的数量，strStack代表最后的字符串
     * @param s
     * @return
     */
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        if (null == s || s.length() == 0) {
            return s;
        }
        Stack<StringBuilder> stack = new Stack<>();
        Stack<Integer> istack = new Stack<>();
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                cnt = cnt * 10 + c - '0';
            } else if (c == '[') {
                istack.push(cnt);
                stack.push(sb);
                sb = new StringBuilder();
                cnt = 0;
            } else if (c == ']') {
                StringBuilder temp = sb;
                sb = stack.pop();
                cnt = istack.pop();
                for (int i = 0; i < cnt; i++) {
                    sb = sb.append(temp);
                }
                cnt = 0;
            } else {
                sb.append(c);
            }
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        EncodedString encodedString = new EncodedString();
        System.out.println(encodedString.decodeString("3[a]2[c]"));
    }
}
