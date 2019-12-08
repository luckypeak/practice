package weekly;

import java.util.*;

/**
 * @url https://leetcode-cn.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/
 * @title 5282. 转化为全零矩阵的最少反转次数
 * @tags 广度优先搜索
 * <p>
 * 给你一个 m x n 的二进制矩阵 mat。
 * <p>
 * 每一步，你可以选择一个单元格并将它反转（反转表示 0 变 1 ，1 变 0 ）。如果存在和它相邻的单元格，那么这些相邻的单元格也会被反转。（注：相邻的两个单元格共享同一条边。）
 * <p>
 * 请你返回将矩阵 mat 转化为全零矩阵的最少反转次数，如果无法转化为全零矩阵，请返回 -1 。
 * <p>
 * 二进制矩阵的每一个格子要么是 0 要么是 1 。
 * <p>
 * 全零矩阵是所有格子都为 0 的矩阵。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  广度遍历搜索
 *  搜索的终止条件: 1. 遍历到所有单元格都是0， 2. 所有的都遍历一遍。使用Map存储遍历过的矩阵。
 *  使用两个队列， queue存储待遍历的矩阵，queue2 存储反转的次数。当queue不为空时，poll出矩阵，进行遍历
 */
public class MatminFlips {

    public int minFlips(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[][] zeroMat = new int[rows][cols];
        String zeroMatString = matrixToString(zeroMat);
        Map<String, Boolean> map = new HashMap<>();
        Queue<int[][]> queue = new LinkedList<>();
        queue.offer(mat);
        Queue<Integer> flipsQueue = new LinkedList<>();
        flipsQueue.offer(0);
        String matString = matrixToString(mat);
        map.put(matString, true);
        while (!queue.isEmpty()) {
            int[][] curMat = queue.poll();
            int flip = flipsQueue.poll();
            matString = matrixToString(curMat);
            if (matString.equals(zeroMatString)) {
                return flip;
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int[][] flipMat = flip(curMat, i, j);
                    String flipStr = matrixToString(flipMat);
                    if (!map.getOrDefault(flipStr, false)) {
                        queue.offer(flipMat);
                        flipsQueue.offer(flip + 1);
                        map.put(flipStr,true);
                    }
                }
            }
        }
        return -1;
    }

    public String matrixToString(int[][] mat) {
        String str = "[";
        int rows = mat.length;
        for (int i = 0; i < rows; i++) {
            int[] row = mat[i];
            String rowStr = Arrays.toString(row);
            if (i > 0)
                str += ", ";
            str += rowStr;
        }
        str += "]";
        return str;
    }

    private int[][] flip(int[][] mat, int row, int column) {
        int rows = mat.length, columns = mat[0].length;
        int[][] flipMat = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                flipMat[i][j] = mat[i][j];
        }
        flipMat[row][column] = 1 - flipMat[row][column];
        if (row > 0)
            flipMat[row - 1][column] = 1 - flipMat[row - 1][column];
        if (row < rows - 1)
            flipMat[row + 1][column] = 1 - flipMat[row + 1][column];
        if (column > 0)
            flipMat[row][column - 1] = 1 - flipMat[row][column - 1];
        if (column < columns - 1)
            flipMat[row][column + 1] = 1 - flipMat[row][column + 1];
        System.out.println(matrixToString(flipMat));
        return flipMat;
    }



    public static void main(String[] args) {
        MatminFlips matminFlips = new MatminFlips();
        int[][] mat = {{1,1,1},{1,0,1},{0,0,0}};
        System.out.println(matminFlips.minFlips(mat));
    }
}
