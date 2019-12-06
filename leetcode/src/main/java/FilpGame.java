import java.util.*;

/**
 * https://leetcode-cn.com/problems/flip-game/
 * 翻转游戏
 */
public class FilpGame {

    public List<String> generatePossibleNextMoves(String s) {
        Set<String> se = new HashSet<>();
        for(int i =0 ; i< s.length(); i++){
            for (int j = i ; j < s.length()-1; j++){
                if (s.charAt(j) == '+' && s.charAt(j+1) == '+'){
                    char[] cr = s.toCharArray();
                    cr[j] = '-';
                    cr[j+1] = '-';
                    se.add(new String(cr));
                    j++;
                }
            }
        }
        return new ArrayList<>(se);


    }

    public List<String> generatePossibleNextMoves2(String s) {
        List<String> se = new ArrayList<>();
        char[] cr = s.toCharArray();
        for(int i =0 ; i< s.length()-1; i++){
            if (cr[i]=='+' && cr[i+1] == '+'){
              char[] temp = s.toCharArray();
              temp[i] = '-';
              temp[i+1] = '-';
              se.add(new String(temp));
            }
        }
        return se;


    }

    /**
     * https://leetcode-cn.com/problems/flip-game-ii/
     * 翻转游戏 II
     * @param s
     * @return
     */
    public boolean canWin(String s) {
        return false;
    }
}
