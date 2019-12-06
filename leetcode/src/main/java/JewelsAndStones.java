import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        int cnt = 0;
        Map<Character,Integer> stoneMap = new HashMap<>();
        for (char c : J.toCharArray()){
            stoneMap.put(c, 1);
        }
        for (char c : S.toCharArray()){
            if (stoneMap.containsKey(c)){
                cnt++;
            }
        }
        return cnt;
    }

}
