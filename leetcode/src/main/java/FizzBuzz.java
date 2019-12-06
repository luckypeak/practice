import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/fizz-buzz/
 * 412. Fizz Buzz
 * 扩展的题解：https://leetcode-cn.com/problems/fizz-buzz/solution/fizz-buzz-by-leetcode/
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
             if (i % 3==0 && i % 5==0){
                 ans.add("FizzBuzz");
             }else if (i % 5== 0){
                 ans.add("Buzz");
             }else if (i % 3 ==0){
                 ans.add("Fizz");
             }else {
                 ans.add(String.valueOf(i));
             }
        }
        return ans;
    }
}
