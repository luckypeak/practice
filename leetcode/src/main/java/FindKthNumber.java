import java.util.Arrays;

public class FindKthNumber {

    /**
     * 440. 字典序的第K小数字
     * https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/
     * 超时
     *
     * @param n
     * @param k
     * @return
     */
    public int findKthNumber1(int n, int k) {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(i + 1);
        }

        Arrays.sort(arr);
        return Integer.parseInt(arr[k - 1]);
    }

    /**
     * 字典序 首先按照首字母排序，依次按照后续字母排序。 注意大小范围
     * 构造十叉树，深度遍历
     *
     * @param n
     * @param k
     * @return
     */
    public int findKthNumber(int n, int k) {
        long cur = 1;
        k--;
        while (k > 0) {
            long left = cur;
            long right = cur + 1;
            int nodeNum = 0;
            while (left < n + 1) { // n+1 生成的数字是1， n
                nodeNum += Math.min(n + 1, right) - left; // 判断 子树的节点数量。 右侧节点-最左侧节点
                left *= 10;
                right *= 10;
            }
            if (nodeNum <= k) { // 走过的节点小于等于k，代表不在这颗子树上，向上计算另外子树
                k -= nodeNum;
                cur++;
            } else { // 大于k，说明在节点上 k ，继续往下查找
                k--;
                cur *= 10;
            }
        }
        return (int) cur;
    }

    public static void main(String[] args) {
        FindKthNumber findKthNumber = new FindKthNumber();
        System.out.print(findKthNumber.findKthNumber(2, 2));
    }
}
