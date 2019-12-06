public class RobotBounded {

    public boolean isRobotBounded(String instructions) {
        int gcnt = 0, lcnt = 0, rcnt = 0;
        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                gcnt++;
            } else if (c == 'L') {
                lcnt++;
            } else {
                rcnt++;
            }
        }

        if (gcnt == 0) {
            return true;
        } else if (lcnt == 0 && rcnt == 0) {
            return false;
        } else {
            if (lcnt > 0 && rcnt > 0) {
                return lcnt % 4 != lcnt % 4;
            } else {
                return true;
            }
        }

    }

    public static void main(String[] args) {
        RobotBounded rb = new RobotBounded();
        System.out.println(3%4);
        System.out.println(1%4);
        System.out.println(rb.isRobotBounded("LL"));
    }
}
