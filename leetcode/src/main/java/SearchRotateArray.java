public class SearchRotateArray {

    public int find_rotate_index(int[] nums) {


        int left = 0;
        int right = nums.length-1;
        if (nums[left] < nums[right])
            return 0;
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1]) {
                return pivot + 1;
            } else {
                if (nums[pivot] < nums[left]) {
                    right = pivot - 1 ;
                } else {
                    left = pivot + 1;
                }
            }
        }
        return 0;
    }

    public int search(int[] nums, int left , int right, int target){
        while (left <= right){
            int mid = (left + right)/2;
            if (nums[mid]== target){
                return mid;
            }
            if (nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid +1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while (left <= right){
            int mid = (left + right)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[left] > nums[mid]){
                if (target > nums[mid] && nums[left] > target){
                    left ++;
                }
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }
        if (nums.length == 1){
            return  nums[0]!=target ? -1 : 0;
        }
        int pivot = find_rotate_index(nums);
        if (nums[pivot] == target){
            return pivot;
        }
        if (pivot == 0)
            return search(nums, 0, nums.length-1, target);

        if (target < nums[0] ){
            return search(nums, pivot , nums.length-1, target);
        }else {
            return search(nums, 0, pivot, target);
        }
    }

    public static void main(String[] args) {
        SearchRotateArray sr = new SearchRotateArray();
        int[] ar = new int[]{8,9,2,3,4};
       System.out.println( sr.search(ar, 9));
    }

}
