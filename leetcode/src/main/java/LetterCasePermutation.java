import java.util.ArrayList;
import java.util.List;


/**
 * https://leetcode-cn.com/problems/letter-case-permutation/
 * 字母大小写全排列
 */
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        dfs(S, res, 0);
        return res;
    }

    private void dfs(String s, List<String> res, int length){
        if (length == s.length()){
            res.add(s);
            return;
        }
        if (Character.isDigit(s.charAt(length))){
            dfs(s, res, length+1);
            return;
        }
        char[] cr = s.toCharArray();
        char c = s.charAt(length);
        cr[length] = Character.toLowerCase(c);
        dfs(new String(cr),res, length+1);
        cr[length] = Character.toUpperCase(c);
        dfs(new String(cr),res, length+1);

    }
}
