import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/largest-number/
 * 179. 最大数
 *  首先排序 按从大倒小
 *  第一种排序思路： 最后返回字符串，所以满足 假设：s1, s2 两个字符串，最后一定的序列一定是 (s1+ s2 , s2+s1)中的最大值
 *  第二种排序思路:  取小数排序，
 *
 *
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        StringBuilder res = new StringBuilder();
        String[] numObjs = new String[nums.length];
        for (int i = 0 ; i<  nums.length ; i++){
            numObjs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numObjs, (o1, o2) -> {
            String order1 = o1 + o2;
            String order2 = o2 + o1;
            return order2.compareTo(order1);

        });
        if (numObjs[0].equals( "0")){
            return "0";
        }
        for (String i : numObjs){
            res.append(i);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LargestNumber ln = new LargestNumber();
        int[] nums = new int[]{26,33,19,29,61,66,52,37,7,76,89,93,72,2,82,11,9,41,47,76,80,28,86,30,99,25,99,85,96,98,88,33,4,94,25,80,19,55,82,71,29,61,15,2,57,98,15,91,27,95,47,38,66,2,78,26,77,33,23,90,73,27,20,5,38,23,35,29,13,46,6,71,58,37,89,28,8,1,8,73,81,83,77,22,63,36,62,89,94,43,25,86,53,21,94,9,40,19,24,21};
        System.out.println(ln.largestNumber(nums));
    }

}
