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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@Component
public class HisUrlContainerUtils  implements ApplicationListener {

    @Autowired
    private HisUrlMapper hisUrlMapper;
    //HashMap<HisUrl.url,HisUrl.flag>
    private static final HashMap<String ,String> hisUrlContainer = new HashMap<String, String>();

    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (((applicationEvent instanceof ContextRefreshedEvent))/* && (null == ((ContextRefreshedEvent)applicationEvent).getApplicationContext().getParent())*/ ){
            initHisUrlContainer();
        }
    }

    /**
     * 初始话容器
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
            String flag = hisUrl.getFlag();
            if(CommonUtils.isNull(url)){
                hisUrlContainer.put(url,flag);
            }
        }
    }

    /**
     * 判断历史url容器中是否包含目标url
     * @param url
     * @return 包含则返回true
     */
    public static boolean contains(String url) throws Exception{
        String  target = null;
        target = hisUrlContainer.get(url);
        //如果url不存在或者flag不为0.则不包含，返回false
        return target == null ? false:target=="0";
    }

    /**
     * 新增历史rul缓存内容
     * @param hisUrl
     * @throws Exception
     */
    public static void addHisUrl(HisUrl hisUrl) throws Exception{
        hisUrlContainer.put(hisUrl.getUrl(),hisUrl.getFlag());
    }

    /**
     * 去除指定url
     * @param hisUrl
     * @throws Exception
     */
    public static  void deleteHisUrl(HisUrl hisUrl) throws Exception{
        hisUrlContainer.remove(hisUrl);
    }

}
