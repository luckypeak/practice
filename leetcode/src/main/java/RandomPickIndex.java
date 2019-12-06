import java.util.Random;

/**
 * https://leetcode-cn.com/problems/random-pick-index/submissions/
 * 随机数索引
 * #tag 蓄水池抽样
 */
public class RandomPickIndex {

    int[] nums ;
    public RandomPickIndex(int[] nums){
            this.nums = nums;
    }

    public int pick(int target) {
        int result = -1;
        int count = 0;
        for(int i = 0; i < nums.length ; i++){
            if (nums[i] != target){
                continue;
            }
            Random random = new Random();
            if (random.nextInt(++count) == 0){
                result = i;
            }
        }
        return result;
    }
}
