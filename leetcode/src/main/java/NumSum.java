import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0 ; i < nums.length ; i++){
            Map<Integer, Integer> cntMap = new HashMap<>();
            int target = 0 - nums[i];
            int first = nums[i];
            for (int j = i; j < nums.length ; j++){
                cntMap.put(target-nums[j], j);
            }
            for (int j = i; j < nums.length ; j++){
                List<Integer> res = new ArrayList<>();
                if (cntMap.containsKey(nums[j]) && cntMap.get(nums[j]) != j){
                    res.add(first);
                    res.add(nums[cntMap.get(nums[j])]);
                    res.add(nums[j]);
                    result.add(res);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ar = new int[]{-1, 0, 1, 2, -1, -4};
        NumSum ns = new NumSum();
        ns.threeSum(ar);
    }
}
