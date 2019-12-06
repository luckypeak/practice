/**
 * https://leetcode-cn.com/problems/add-strings/
 * 字符串相加
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        if (num1 == null) {
            return num2;
        }
        if (num2 == null) {
            return num1;
        }
        StringBuilder sb = new StringBuilder();
        if (num2.length() > num1.length()) {
            String temp = num2;
            num2 = num1;
            num1 = temp;
        }
        int isCarry = 0;
        int length1 = num1.length() - 1;
        int length2 = num2.length() - 1;
        for (; length1 >= 0 && length2 >= 0; length1--, length2--) {
            char c1 = num1.charAt(length1);
            char c2 = num2.charAt(length2);
            int res = Character.getNumericValue(c1) + Character.getNumericValue(c2) + isCarry;
            if (res / 10 > 0) {
                isCarry = 1;
            } else {
                isCarry = 0;
            }
            sb.append(res % 10);

        }
        if (length1 >= 0) {
            for (; length1 >= 0; length1--) {
                char c1 = num1.charAt(length1);
                int res = Character.getNumericValue(c1) + isCarry;
                if (res / 10 > 0) {
                    isCarry = 1;
                } else {
                    isCarry = 0;
                }
                sb.append(res % 10);
            }
        }

        if (isCarry > 0) {
            sb.append(isCarry);
        }


        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        AddStrings as = new AddStrings();
        System.out.println(as.addStrings("911", "90"));
    }
}
