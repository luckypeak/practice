package weekly;

import java.util.Arrays;

/**
 * A 和 B 在一个 3 x 3 的网格上玩井字棋。
 *
 * 井字棋游戏的规则如下：
 *
 * 玩家轮流将棋子放在空方格 (" ") 上。
 * 第一个玩家 A 总是用 "X" 作为棋子，而第二个玩家 B 总是用 "O" 作为棋子。
 * "X" 和 "O" 只能放在空方格中，而不能放在已经被占用的方格上。
 * 只要有 3 个相同的（非空）棋子排成一条直线（行、列、对角线）时，游戏结束。
 * 如果所有方块都放满棋子（不为空），游戏也会结束。
 * 游戏结束后，棋子无法再进行任何移动。
 * 给你一个数组 moves，其中每个元素是大小为 2 的另一个数组（元素分别对应网格的行和列），它按照 A 和 B 的行动顺序（先 A 后 B）记录了两人各自的棋子位置。
 *
 * 如果游戏存在获胜者（A 或 B），就返回该游戏的获胜者；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 *
 * 你可以假设 moves 都 有效（遵循井字棋规则），网格最初是空的，A 将先行动。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-winner-on-a-tic-tac-toe-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Tictactoe {


    public String tictactoe(int[][] moves){
        int[][] board = new int[3][3];
        for (int i = 0 ; i < 3; i++){
            Arrays.fill(board[i], 0);
        }
        for (int i = 0 ; i < moves.length;i++){
            if (i % 2==0){
                board[moves[i][0]][moves[i][1]] = 1;
            }else {
                board[moves[i][0]][moves[i][1]] = -1;
            }
        }

        // 计算横 纵坐标，如果某一方赢，则和一定等于3
        for (int i = 0 ; i < 3; i++){
            int rowNum = 0 ;
            int colNum = 0;
            for (int j = 0; j < 3; j++){
                rowNum += board[i][j];
                colNum += board[j][i];
            }
            if (rowNum == 3 || colNum == 3){
                return "A";
            }

            if (rowNum == -3 || colNum == -3){
                return "B";
            }
        }
        // 计算对角线
        int d1 = 0 ;
        int d2 = 0 ;
        for (int i = 0; i < 3; i++){
            d1 +=board[i][i];
            d2 += board[i][2-i];
        }

        if (d1 == 3 || d2 ==3){
            return "A";
        }

        if (d1 == -3 || d2 ==-3){
            return "B";
        }

        if (moves.length == 9){
            return "Draw";
        }

        return "Pending";
    }
}
