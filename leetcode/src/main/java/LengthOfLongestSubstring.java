public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.equals("")){
            return 0;
        }
        boolean[] charArr = new boolean[256];
        int first = 0;
        int end = 0;
        int max = 0;
        char[] sArr = s.toCharArray();
        while (first < s.length()){
            while (end < s.length()){
                if (!charArr[sArr[end]]){
                    charArr[sArr[end]] = true;
                    end ++;
                    max = Math.max(max, end-first);
                }else {
                    break;
                }
            }
            first ++;
            end = first;
            for (int i = 0 ; i<256;i++){
                charArr[i] = false;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
    }
}
