package weekly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 5113. 删除区间 显示英文描述
 * 用户通过次数408
 * 用户尝试次数469
 * 通过次数415
 * 提交次数883
 * 题目难度Medium
 * 给你一个 有序的 不相交区间列表 intervals 和一个要删除的区间 toBeRemoved， intervals 中的每一个区间 intervals[i] = [a, b] 都表示满足 a <= x < b 的所有实数  x 的集合。
 *
 * 我们将 intervals 中任意区间与 toBeRemoved 有交集的部分都删除。
 *
 * 返回删除所有交集区间后， intervals 剩余部分的 有序 列表。
 */
public class RemoveInterval {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        if (intervals.length == 0){
            return res;
        }
        int start = toBeRemoved[0];
        int end = toBeRemoved[1];
        List<Integer> flat = new ArrayList<Integer>();
        for(int[] ans : intervals){
            flat.add(ans[0]);
            flat.add(ans[1]);
        }
        if (end < flat.get(0) || start > flat.get(flat.size()-1)){
            return res;
        }
        Object[] temp = flat.toArray();
        int startIndex = Arrays.binarySearch(temp, start) ;
        startIndex = startIndex > 0 ? startIndex: -(startIndex-1);
        int endIndex = Arrays.binarySearch(temp,end);
        endIndex = endIndex > 0 ? endIndex: -(endIndex-1);
        for (int i = 0 ; i < intervals.length; i++){
            List<Integer> l = new ArrayList();
            if (intervals[i][0] > end){
                return res;
            }

            if (intervals[i][0] > start){
                l.add(start);
            }else{
                l.add(intervals[i][0]);
            }
            if (intervals[i][1] <= end){
                l.add(intervals[i][0]);
            }else {
                l.add(end);
            }
         res.add(l);
        }
        return res;
    }

    public static void main(String[] args) {
        RemoveInterval removeInterval = new RemoveInterval() ;
        int[][] intervals = new int[][]{{0,2},{3,4},{5,7}};
        int[] toBeRemoved = new int[]{8,7};
        List res = removeInterval.removeInterval(intervals, toBeRemoved);
        System.out.println(res);
    }

}
