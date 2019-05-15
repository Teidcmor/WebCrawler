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

    /**
     * 管理员账户类型
     */
    public static String USER_TYPE_ADMIN ="1";
    /**
     * 普通用户类型
     */
    public static String USER_TYPE_SIMPLE = "0";

    /**
     * 用户性别：男
     */
    public static String USER_SEX_MAN = "1";

    /**
     * 用户性别：女
     */
    public static String USER_SEX_WUMAN = "0";

    /**
     * 用户账号可用
     */
    public static String USER_ENABLE = "1";

    /**
     * 用户账号不可用
     */
    public static String USER_UNENABLE = "0";

    /**
     * 主页面排序方式：默认排序
     */
    public static String SORT_TYPE_1 = "1";

    /**
     * 主页面排序方式：默认排序
     */
    public static String SORT_TYPE_2 = "2";

    /**
     * 主页面排序方式：默认排序
     */
    public static String SORT_TYPE_3 = "3";

    /**
     * 有效信息展示页面分页大小
     */
    public static int CORE_DATA_PAGE_SIZE = 9;

    /**
     * 用户展示页面分页大小
     */
    public static int USER_PAGE_SIZE = 5;

}
