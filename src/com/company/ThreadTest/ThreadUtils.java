package com.company.ThreadTest;

public class ThreadUtils {
    /**
     * showThreadInfo
     *
     * @return
     */
    public static final String showThreadInfo() {

        return "^^^^^^^^^^^^^^^^^^^^^^^ currentThread: name=" + Thread.currentThread().getName() + "  , id="
                + Thread.currentThread().getId() +

                "   ,state=" + Thread.currentThread().getState() + "   , Priority=" + Thread.currentThread().getPriority();
    }

    /**
     * sleep not catch Exception
     *
     * @param ms
     * @return
     */
    public static boolean sleep(int ms) {
        try {
            Thread.sleep(ms);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }
}
