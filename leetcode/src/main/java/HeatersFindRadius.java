import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/heaters/
 * 供暖器
 * 二分查找 寻找每个房间距离供暖的最大值。for循环每个房间在供暖数组里面寻找相邻最近的数子
 * 判断相邻最近，供暖数组排序生成有序数组，使用二分查找，找到最近的。注意二分查找的边界值。
 *
 *
 */

public class HeatersFindRadius {
    int bisec(int[] heaters, int target) {
        int l = 0;
        int h = heaters.length - 1;
        while (l < h -1) {
            int mid = (l + h) / 2;
            if (heaters[mid] == target) {
                return heaters[mid];
            } else if (heaters[mid] > target) {
                h = mid ;
            } else {
                l = mid ;
            }
        }
        if (Math.abs(heaters[l] - target) > Math.abs(heaters[h] - target)) {
            return heaters[h];
        }
        return heaters[l];
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < houses.length; i++) {
            max = Math.max(max, Math.abs(bisec(heaters, houses[i]) - houses[i]));
        }

        return max;
    }

    public static void main(String[] args) {
        HeatersFindRadius heatersFindRadius = new HeatersFindRadius();
        int[] house = new int[]{1,2,3,4};
        int[] heaters = new int[]{2};
        int res = heatersFindRadius.findRadius(house, heaters);
        System.out.println(res);
    }
}
