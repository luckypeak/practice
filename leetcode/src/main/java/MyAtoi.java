public class MyAtoi {

    public int myAtoi(String str) {
        char[] ar = str.toCharArray();
        boolean isPostive = true;
        int result = 0;
        boolean isStart = false;
        for (char c : ar) {
            if (c == '-' && result == 0 && !isStart) {
                isPostive = false;
                isStart = true;
                continue;
            }
            if (c == '+' && result == 0 && !isStart) {
                isStart = true;
                continue;
            }
            if (c == ' ' && !isStart) {
                continue;
            }
            if (!Character.isDigit(c)) {
                break;
            }
            isStart = true;
            int num = Character.digit(c, 10);
            if (result > Integer.MAX_VALUE / 10 ) {
                return isPostive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            if (result == Integer.MAX_VALUE /10 && num > 7){
                return isPostive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + num;
        }
        return isPostive ? result : -1 * result;
    }

    public static void main(String[] args) {
        System.out.println(new MyAtoi().myAtoi("2147483648"));
    }

}
