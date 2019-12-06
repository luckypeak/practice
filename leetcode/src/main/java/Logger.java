import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/logger-rate-limiter/
 * 日志速率限制器
 */
public class Logger {
    private Map<String, Integer> loggerContent;

    /**
     * Initialize your data structure here.
     */
    public Logger() {
        this.loggerContent = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {

        Integer lastTimestamp = loggerContent.get(message);

        if (lastTimestamp == null) {
            loggerContent.put(message, timestamp);
            return true;
        }
        if (timestamp - lastTimestamp < 10) {
            return false;
        }
        loggerContent.put(message, timestamp);
        return true;


    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */