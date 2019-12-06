public class ReverseInterger {

    public int reverse(int x){
        if (x == 0){
            return x;
        }
        StringBuilder  newS = new StringBuilder();
        if (x < 0){
            newS.append("-");
        }
        x = Math.abs(x);
        String s = String.valueOf(x);
        boolean isFirst = true;
        int length = s.length() - 1;
        for (; length >= 0; length --){
            char c = s.charAt(length);
            if (c == '0' && isFirst){
                continue;
            }else {
                isFirst = false;
            }
            newS.append(c);
        }
        try{
            return Integer.parseInt(newS.toString());
        }catch (NumberFormatException e){
            return 0;
        }


    }

    public int reverse1(int x){
        int res = 0;
        while (x != 0){
            if (Math.abs(res) > Integer.MAX_VALUE/10){
                return 0;
            }
            res = res * 10 + x%10;
            x = x/10;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new ReverseInterger().reverse1(1534236469));
        System.out.println(new ReverseInterger().reverse1(-1120));
    }
}
