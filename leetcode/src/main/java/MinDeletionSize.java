/**
 * https://leetcode-cn.com/problems/delete-columns-to-make-sorted/
 * 删列造序
 */
public class MinDeletionSize {


    public int minDeletionSize(String[] A) {
        int ans = 0;
        for (int i = 0; i< A[0].length(); i++){
            for (int j = 1; j < A.length ; j++){
                if (A[j].charAt(i) < A[j-1].charAt(i)){
                    ans++;
                    break;
                }
            }

        }
        return ans;
    }

}
