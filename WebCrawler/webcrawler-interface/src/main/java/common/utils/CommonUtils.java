package common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {

    /**
     * 获取系统当前日期
     * @return
     */
    public static String getCurrentDate(){
        Date currentDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String target = simpleDateFormat.format(currentDate);
        return target;
    }

    /**
     * 获取系统当前时间
     * @return
     */
    public static String getCurrentTime(){
        Date currentDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String target = simpleDateFormat.format(currentDate);
        return target;
    }

    /**
     * 获取系统当前日期和时间
     * @return
     */
    public static String getCurrentDateAndTime(){
        Date currentDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String target = simpleDateFormat.format(currentDate);
        return target;
    }

    /**
     * 判断字符串是否相等
     * @param source
     * @param target
     * @return
     */
    public static boolean stringEquals(String source,String target){
        return source == null ? target == null : source.equals(target);
    }

    /**
     * 判断字符串是否为空，为空返回true
     * @param target
     * @return
     */
    public static boolean isNull(String target){
        return target == null ? true : target == "";
    }

}
