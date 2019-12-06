public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs== null || strs.length == 0){
            return "";
        }


        StringBuilder res = new StringBuilder();
        for (int i = 0; i< strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for( int j =1 ; j < strs.length ; j++){
                int jl = strs[j].length();
                if (jl  <=  i || strs[j].charAt(i) != c){
                    return res.toString();
                }
            }
            res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"abab","aba",""}));
    }


}
