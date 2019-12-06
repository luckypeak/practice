import java.util.Stack;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int length = 1;
        int pre = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                length++;
                pre++;
                nums[pre] = nums[i];
            }
        }
        return length;
    }

    /**
     * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
     * 1047. 删除字符串中的所有相邻重复项
     *
     * @param S
     * @return
     */
    public String removeDuplicates(String S) {
        if (S == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
