import java.util.Stack;

public class IsValidReplace {

    /**
     * https://leetcode-cn.com/problems/check-if-word-is-valid-after-substitutions/
     * 1003.检查替换后的词是否有效
     *
     * @param S
     * @return
     */
    public boolean isValid2(String S) {
        if (null == S) {
            return false;
        }
        while (S.contains("abc")) {
            S = S.replace("abc", "");
        }
        return S.isEmpty();
    }

    public boolean isValid(String S) {
        if (null == S) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == 'c') {
                if (stack.isEmpty() || stack.pop() != 'b') {
                    return false;
                }
                if (stack.isEmpty() || stack.pop() != 'a') {
                    return false;
                }
            } else {
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }
}

