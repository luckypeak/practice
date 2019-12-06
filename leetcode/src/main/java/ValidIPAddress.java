public class ValidIPAddress {

    public String validIPAddress(String IP) {
        if (IP == null || IP.length() == 0) {
            return "Neither";
        }
        if (IP.lastIndexOf(".") == IP.length() - 1) {
            return "Neither";
        }
        if (IP.indexOf(".") > 0) {
            String[] ipArr = IP.split("\\.");
            if (ipArr.length != 4) {
                return "Neither";
            }
            for (String item : ipArr) {
                if (item.indexOf("0") == 0 && item.length() > 1) {
                    return "Neither";
                }
                try {
                    if (Integer.parseInt(item) > 255 || Integer.parseInt(item) < 0 || item.contains("-") || item.contains("+")) {
                        return "Neither";
                    }
                } catch (Exception e) {
                    return "Neither";
                }

            }
            return "IPv4";
        }
        if (IP.lastIndexOf(":") == IP.length() - 1) {
            return "Neither";
        }
        if (IP.indexOf(":") > 0) {
            String[] ipArr = IP.split(":");
            if (ipArr.length != 8) {
                return "Neither";
            }
            for (String item : ipArr) {
                if (item.length() == 0 || item.length() > 4) {
                    return "Neither";
                }
                for (char c : item.toCharArray()) {
                    if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) return "Neither";
                }
            }
            return "IPv6";
        }
        return "Neither";

    }

    public static void main(String[] args) {
        System.out.println(new ValidIPAddress().validIPAddress("192.0.0.1"));
    }
}
