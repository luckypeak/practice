import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permute {

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    /**
     * https://leetcode-cn.com/problems/permutations/
     * 46.全排列
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> nums_list = new ArrayList<>();
        for (int i : nums) {
            nums_list.add(i);
        }
        permuteList(nums.length, nums_list, ans, 0);
        return ans;
    }

    public void permuteList(int n, List<Integer> nums, List<List<Integer>> ans, int k) {
        if (k == n) {
            ans.add(new ArrayList<>(nums));
        }
        for (int i = k; i < n; i++) {
            Collections.swap(nums, k, i);
            permuteList(n, nums, ans, k + 1);
            Collections.swap(nums, k, i);
        }
    }

    /**
     * https://leetcode-cn.com/problems/permutations-ii/
     * 47.全排列II
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> nums_list = new ArrayList<>();
        if (nums.length == 0){
            return ans;
        }
        for (int i : nums) {
            nums_list.add(i);
        }
        permuteList2(nums.length, nums_list, ans, 0);
        return ans;
    }

    public void permuteList2(int n, List<Integer> nums, List<List<Integer>> ans, int k) {
        if (k == n) {
            ans.add(new ArrayList<>(nums));
        }
        for (int i = k; i < n; i++) {
            if (i != k && nums.get(i).equals(nums.get(k))){
                continue;
            }
            Collections.swap(nums, k, i);
            permuteList2(n, nums, ans, k + 1);
            Collections.swap(nums, k, i);
        }
    }


    public static void main(String[] args) {
        Permute permute = new Permute();
        int[] nums = new int[]{2,2,1,1};
        List<List<Integer>> ans = permute.permuteUnique(nums);
        for (List<Integer> l : ans){
            for(Integer i : l){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
