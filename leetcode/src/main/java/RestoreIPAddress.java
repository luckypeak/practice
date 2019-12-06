import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/restore-ip-addresses/solution/fu-yuan-ipdi-zhi-by-leetcode/
 * 复原ip地址
 */
public class RestoreIPAddress {

    public List<String> restoreIpAddresses2(String s) {
        List<String> ans = new ArrayList<>();
        dfs(s, 0, 0, "", ans);
        return ans;
    }

    private void dfs(String s, int ipx, int count, String ip, List<String> ans) {
        if (count > 4) {
            return;
        }
        if (count == 4 && ipx == s.length()) {
            ans.add(ip);
        }

        for (int i = 1; i < 4 && ipx + i <= s.length(); i++) {
            String temp = s.substring(ipx, ipx + i);
            if ((temp.charAt(0) == '0' && temp.length() > 1) || Integer.parseInt(temp) > 255) {
                continue;
            }
            dfs(s, ipx + i, count + 1, ip + temp + (count == 3 ? "" : "."), ans);
        }
    }


    /**
     * 暴力循环，通过约束规划限制结束条件优化循环。
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 4 && i < s.length() - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < s.length() - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < s.length(); k++) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        String temp = s1 + "." + s2 + "." + s3 + "." + s4;
                        ans.add(temp);

                    }

                }
            }
        }
        return ans;
    }

    private boolean isValid(String s) {
        if (s.length() > 3 || s.length() == 0 || Integer.parseInt(s) > 255 || (s.length() > 1 && s.charAt(0) == '0')) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        RestoreIPAddress ria = new RestoreIPAddress();
        ria.restoreIpAddresses2("25525511135");
        String s = "sasasa";
        System.out.println(s.substring(2, s.length()-1));
    }

}
