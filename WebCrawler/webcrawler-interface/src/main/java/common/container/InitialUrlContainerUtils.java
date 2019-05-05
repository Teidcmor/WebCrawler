package common.container;

import common.mapper.InitialUrlMapper;
import common.pojo.InitialUrl;
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

//@Component
public class InitialUrlContainerUtils implements ApplicationListener {

    @Autowired
    private InitialUrlMapper initialUrlMapper;

    private static  HashMap<String,String> initialUrlContainer = new HashMap<String, String>();

    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (((applicationEvent instanceof ContextRefreshedEvent))/* && (null == ((ContextRefreshedEvent)applicationEvent).getApplicationContext().getParent())*/ ){
            this.initInitialUrlContainer();
        }
    }

    /**
     * 初始化缓存容器
     */
    private void initInitialUrlContainer(){
        if(this.initialUrlMapper == null)
            this.initialUrlMapper = SpringContextUtils.getAppContext().getBean(InitialUrlMapper.class);
        ArrayList<InitialUrl> list = (ArrayList<InitialUrl>) this.initialUrlMapper.getAllInitialUrl();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            InitialUrl target = (InitialUrl) iterator.next();
            String url = target.getUrl();
            String status = target.getStatus();
            if(!CommonUtils.isNull(url)){
                initialUrlContainer.put(url,status);
            }
        }
    }

    /**
     * 新增初始URL到缓存
     * @param initialUrl
     */
    public static void addInitialUrl(InitialUrl initialUrl){
        initialUrlContainer.put(initialUrl.getUrl(),initialUrl.getStatus());
    }

    /**
     * 删除某条URL记录
     * @param initialUrl
     */
    public static void deleteInitialUrl(InitialUrl initialUrl){
        initialUrlContainer.remove(initialUrl.getUrl());
    }

    public static boolean contains(String url){
        String target = initialUrlContainer.get(url);
        return target == null?false:true;
    }


}
