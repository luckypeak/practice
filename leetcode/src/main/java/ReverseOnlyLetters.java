/**
 * https://leetcode-cn.com/problems/reverse-only-letters/
 * 917. 仅仅反转字母
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        if (null == S){
            return null;
        }
        char[] arr  = S.toCharArray();
        for (int i = 0, j = S.length()-1 ; i <= j ;){
            if (isValid(S.charAt(i)) && isValid(S.charAt(j)) ){
                arr[i] = S.charAt(j);
                arr[j] = S.charAt(i);
                i++;
                j--;
            }else if (isValid(S.charAt(i))) {
                arr[j] = S.charAt(j);
                j--;
            }else {
                arr[i] = S.charAt(i);
                i++;
            }
        }
        return new String(arr);
    }

    private  boolean isValid(char c){
        return Character.isLowerCase(c) || Character.isUpperCase(c);
    }

    public static void main(String[] args) {
        ReverseOnlyLetters reverseOnlyLetters = new ReverseOnlyLetters();
        System.out.print(reverseOnlyLetters.reverseOnlyLetters("a-bC-dEf-ghIj"));
    }
}
