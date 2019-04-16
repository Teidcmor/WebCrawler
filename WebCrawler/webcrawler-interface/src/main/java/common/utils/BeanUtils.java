package common.utils;

public class BeanUtils {

    /**
     * 属性拷贝
     * @param source 数据源
     * @param type 目标对象数据类型
     * @param <T>
     * @param <S>
     * @return
     * @throws Exception
     */
    public static <T,S> T copyObject(S source, Class<T> type) throws Exception{
        try {
            T target = type.newInstance();
            if(source==null){
                return target;
            }
            else {
                org.springframework.beans.BeanUtils.copyProperties(source,target);
                return target;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            throw new Exception("拷贝对象时出错");
        }
    }

    /**
     * 属性拷贝，带过滤条件
     * @param source
     * @param type
     * @param ignoreProperties
     * @param <T>
     * @param <S>
     * @return
     * @throws Exception
     */
    public static <T,S> T copyObject(S source, Class<T> type ,String... ignoreProperties) throws Exception{
        try {
            T target = type.newInstance();
            if(source==null){
                return target;
            }
            else {
                org.springframework.beans.BeanUtils.copyProperties(source,target,ignoreProperties);
                return target;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            throw new Exception("拷贝对象时出错");
        }
    }
}
