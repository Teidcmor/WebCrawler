package common.utils;

public class BeanUtils {

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
}
