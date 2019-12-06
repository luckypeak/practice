/**
 *https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/submissions/
 * 1比特与2比特字符
 */
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length - 1; i++) {
            if (bits[i] == 1) {
                i++;
            }
            if (i == bits.length - 1) {
                return false;
            }
        }
        return true;
    }
}

public class FBitOrSbit {

}
