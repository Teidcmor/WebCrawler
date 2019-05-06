package common.utils;

public class ConstantUtils {

    /**
     * 成功返回值
     */
    public static String SUCCESS = "success";
    /**
     * 失败返回值
     */
    public static String FAILED = "failed";
    /**
     * 默认超时时长
     */
    public static int TIMEOUT = 2000;
    /**
     * 登录失败返回值
     */
    public static String LOGIN_FAILED = "用户名或密码错误";
    /**
     * 注册失败返回值
     */
    public static String REGISTER_FAILED = "注册失败！用户名已存在！";

    /**
     * 爬虫程序开关参数
     *  0 ： 爬虫程序关闭
     *  1 ； 爬虫程序开启
     */
    public static String SPIDER_ENABLE = "spider_enable";

    /**
     * 有效信息定时任务开关，关闭时，定时任务失效
     *  0 ： 关闭
     *  1 ； 开启
     */
    public static String CORE_DATA_SPIDER = "core_data_spider";

}
