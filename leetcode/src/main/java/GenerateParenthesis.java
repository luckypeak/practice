import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 22.括号生成
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateOneByOne(res, n, n, "");
        return res;
    }

    private void generateOneByOne(List<String> list, int left, int right, String res){
        if (right == 0 ){
            list.add(res);
            return;
        }
        if (left > 0){
            generateOneByOne(list, left-1, right, res + "(");
        }
        if (right > 0 && left < right){
            generateOneByOne(list, left, right-1, res + ")");
        }
    }

    public static void main(String[] args) {
        List<String> res;
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        res = generateParenthesis.generateParenthesis(3);
        for (String s : res){
            System.out.println(s);
        }
    }

}
