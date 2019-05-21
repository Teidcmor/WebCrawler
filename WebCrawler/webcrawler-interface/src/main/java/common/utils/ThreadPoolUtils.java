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

    /**
     * 获取线程池对象
     * @return
     */
    public static ThreadPoolExecutor getPoolExecutor()
    {
        return poolExecutor;
    }

    /**
     * 判断线程池内是否还有线程
     * @return
     */
    public static boolean isThreadPoolEmpty(){
        return poolExecutor.getQueue().isEmpty();
    }

}
