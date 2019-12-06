package weekly;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HexSpeak {
    public String toHexspeak(String num) {
        if (num == null){
            return "ERROR";

        }
        String hex  = Long.toHexString(Long.parseLong(num));
        String[] vaild = new String[]{"A", "B", "C", "D", "E", "F", "1", "0"};
        Set<String> set = new HashSet<>(Arrays.asList(vaild));
        StringBuilder sb = new StringBuilder();
        for(char c : hex.toCharArray()){
            if (!set.contains(String.valueOf(c).toUpperCase())){
                return "ERROR";
            }
            if (c == '1'){
                c = 'I';
            }
            if (c== '0'){
                c = 'O';
            }
            sb.append(c);
        }
        return sb.toString().toUpperCase();
    }

    public static void main(String[] args) {
        HexSpeak hexSpeak = new HexSpeak();
        System.out.println("10");
        System.out.println(hexSpeak.toHexspeak("747823223228"));

    }
}
