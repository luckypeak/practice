import java.util.*;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 17. 电话号码的字母组合
 */
public class LetterCombinations {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() > 0){
            backtrack("", digits);
        }

        return ans;

    }

    /**
     * 利用队列特性，每次把所有字符串全部入队，再继续出对相加
     * @param digits
     * @return
     */
    public List<String> letterCombinations2(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.length() == 0){
            return ans;
        }
        ans.add("");
        for (int i = 0 ; i< digits.length() ; i++){
            while (ans.peek().length() == i){
                String t = ans.remove();
                for (char c : phone.get(String.valueOf(digits.charAt(i))).toCharArray()){
                    ans.add(t + c);
                }
            }
        }
        return ans;

    }

    private void backtrack(String combination, String nextDigit){
        if (nextDigit.length() == 0){
            ans.add(combination);
        }
        if (nextDigit.length() == 0){
            return;
        }
        String digit = nextDigit.substring(0, 1);
        String letter = phone.get(digit);
        for (int i = 0; i < letter.length(); i++){
            backtrack(combination + letter.charAt(i), nextDigit.substring(1));
        }
    }



    public static void main(String[] args) {
        LetterCombinations lcb = new LetterCombinations();
        System.out.println(lcb.letterCombinations2("23"));
    }
}
