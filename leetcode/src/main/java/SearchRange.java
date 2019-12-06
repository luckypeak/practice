public class SearchRange {

    int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = (hi + lo) / 2;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public int[] searchRange2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[]{-1, -1};
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
                right = mid;
                while (left >= 0 && nums[left] == target) {
                    left--;
                }
                res[0] = left + 1;
                while (right < nums.length && nums[right] == target) {
                    right++;
                }
                res[1] = right - 1;
                break;
            }
        }
        return res;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int leftIndex = extremeInsertionIndex(nums, target, true);
        if (leftIndex >= nums.length || nums[leftIndex] != target) {
            return res;
        }
        int rightIndex = extremeInsertionIndex(nums, target, false);
        res[0] = leftIndex;
        res[1] = rightIndex - 1;

        return res;
    }

    public static void main(String[] args) {
        SearchRange sr = new SearchRange();
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] res = sr.searchRange(nums, 8);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

}
