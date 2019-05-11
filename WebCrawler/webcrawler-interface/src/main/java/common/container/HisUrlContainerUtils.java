package common.container;

import common.mapper.HisUrlMapper;
import common.pojo.HisUrl;
import common.utils.CommonUtils;
import common.utils.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class HisUrlContainerUtils  implements ApplicationListener {
    @Autowired
    private HisUrlMapper hisUrlMapper;
    private static final Map<String ,HisUrl> hisUrlContainer = new Hashtable<String, HisUrl>();
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (((applicationEvent instanceof ContextRefreshedEvent))
            /* && (null == ((ContextRefreshedEvent)applicationEvent).getApplicationContext().getParent())*/ ){
            initHisUrlContainer();
        }
    }
    /**
     * 初始化容器
     */
    private void initHisUrlContainer(){
        //自动注入失败，手动注入
        if(this.hisUrlMapper == null)
            this.hisUrlMapper = SpringContextUtils.getAppContext().getBean(HisUrlMapper.class);
        //查询所有历史url信息
        ArrayList<HisUrl> list = (ArrayList<HisUrl>) this.hisUrlMapper.getAllHisUrl();
        //循环所有历史url信息，初始化容器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            HisUrl hisUrl = (HisUrl) iterator.next();
            String url = hisUrl.getUrl();
            hisUrlContainer.put(url,hisUrl);
        }
    }
    /**
     * 判断历史url容器中是否包含目标url,并且盖URL为不可重复爬取的状态
     * @param url
     * @return 缓存容器中有目标URL而且标志为0则包含返回true
     */
    public static boolean contains(String url) throws Exception{
        HisUrl hisUrl = hisUrlContainer.get(url);
        if(hisUrl == null){
            return false;
        }else {
            return "0".equals(hisUrl.getFlag())?true:false;
        }
    }
    /**
     * 判断缓存容器中是否包含目标URL，不管状态如何，包含则返回true
     * @param url
     * @return
     * @throws Exception
     */
    public static boolean isContains(String url) throws Exception{
        return hisUrlContainer.get(url) == null?false:true;
    }
    /**
     * 新增历史rul缓存内容
     * @param hisUrl
     * @throws Exception
     */
    public static void addHisUrl(HisUrl hisUrl) throws Exception{
        hisUrlContainer.put(hisUrl.getUrl(),hisUrl);
    }
    /**
     * 去除指定url
     * @param hisUrl
     * @throws Exception
     */
    public static  void deleteHisUrl(HisUrl hisUrl) throws Exception{
        hisUrlContainer.remove(hisUrl.getUrl());
    }

}
