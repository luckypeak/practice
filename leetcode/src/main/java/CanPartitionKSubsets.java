import java.util.Arrays;

public class CanPartitionKSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int target = nums[0];
        canPartitionKSubsets(nums, target);
        return false;
    }

}
