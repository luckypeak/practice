public class RemoveElement {

    public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public int removeElement3(int[] nums, int val) {
        int i = 0;
        int n = nums.length - 1;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n-1];
                 n--;
            } else {
                i++;
            }
        }
        return i;
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1 && nums[0] != val) {
            return 1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val) {
                while (nums[right] == val) {
                    if (left > right) {
                        return left;
                    }
                    right--;

                }
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

            }
            left++;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 2, 3};
        System.out.println(new RemoveElement().removeElement(a, 3));
    }

}
