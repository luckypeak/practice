import java.util.ArrayList;
import java.util.List;

public class ZMartix {

    public static void main(String[] args) {
        int[][] martix = new int[3][4];
        int x = 0, y = 0, row = martix.length, col = martix[0].length;
        List<Integer> ans = new ArrayList<>();
        while (ans.size() < (row + 1) * (col + 1)) {
            for (int i = 0; i < row; i++) {
                ans.add(martix[x][y]);
            }
            x++;
        }
    }

}
