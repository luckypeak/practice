package weekly;

import java.util.*;

/**
 * @url https://leetcode-cn.com/problems/group-the-people-given-the-group-size-they-belong-to/
 * @title 5280.用户分组
 * @tags 贪心算法
 *
 */
public class UserGroup {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++){
            List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<Integer>());
            list.add(i);
            map.put(groupSizes[i],list);
        }

        for (Integer cnt : map.keySet()){
            List<Integer> value = map.get(cnt);
            for (int j = 0 ; j < value.size(); ){
                List<Integer> cur = new ArrayList<>();
                for (int i = 0; i < cnt; i++, j++){
                    cur.add(value.get(j));
                }
                res.add(cur);
            }

        }

        return res;
    }

    public static void main(String[] args) {
        UserGroup userGroup = new UserGroup();
        int[] arr = new int[]{3,3,3,3,3,1,3};
        userGroup.groupThePeople(arr);
    }

}
