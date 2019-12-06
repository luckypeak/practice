import java.util.Arrays;
import java.util.Comparator;

public class FindLongestChain {

    public int dpFindLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
        int []dp = new int[pairs.length];
        dp[0] = 1;
        for (int i = 1 ; i < pairs.length ; i++){
            for (int j = 0 ; j < pairs.length; j++){
                if (pairs[i][0] > pairs[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }else {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
        }
        return dp[pairs.length-1];
    }
    public int findLongestChain(int[][] pairs){
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int end = pairs[0][1];
        int max = 1;
        for (int[] pair : pairs) {
            if (pair[0] > end) {
                end = pair[1];
                max++;
            }
        }
        return max;
    }



    public static void main(String[] args) {
        int [][]pairs = {{1,2}, {2,3}, {3,4}};
        new FindLongestChain().findLongestChain(pairs);

    }
}
