package common.utils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtils {

    private static final ThreadPoolExecutor poolExecutor;

    static
    {
        poolExecutor = new ThreadPoolExecutor(0, 5, 0L, TimeUnit.MINUTES, new LinkedBlockingQueue());
    }

    public static ThreadPoolExecutor getPoolExecutor()
    {
        return poolExecutor;
    }

}
