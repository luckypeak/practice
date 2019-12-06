import java.util.ArrayList;
import java.util.List;

public class LargeGroupPositions {
    /**
     * https://leetcode-cn.com/problems/positions-of-large-groups/
     * 830. 较大分组数量
     *
     * @param S
     * @return
     */
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        if (null == S || S.length() == 0) {
            return ans;
        }
        int pre = 0;
        for (int cur = 1; cur < S.length(); ) {
            while (cur < S.length() && S.charAt(cur) == S.charAt(pre)) {
                cur++;
            }
            int distance = cur - pre - 1 ;
            if (distance >= 2) {
                List<Integer> res = new ArrayList<>();
                res.add(pre);
                res.add(cur - 1);
                ans.add(res);
            }
            pre = cur;
            cur++;

        }
        return ans;

    }

    public static void main(String[] args) {
        LargeGroupPositions largeGroupPositions = new LargeGroupPositions();
        largeGroupPositions.largeGroupPositions("abbxxxxzzy");
    }

}
