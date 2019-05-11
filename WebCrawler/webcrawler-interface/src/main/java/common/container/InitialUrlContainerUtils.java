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

import java.util.*;

@Component
public class InitialUrlContainerUtils implements ApplicationListener {
    @Autowired
    private InitialUrlMapper initialUrlMapper;
    private static Map<String,InitialUrl> initialUrlContainer = new Hashtable<String, InitialUrl>();
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (((applicationEvent instanceof ContextRefreshedEvent)) ){
            this.initInitialUrlContainer(); } }
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
            if(!CommonUtils.isNull(url)){
                initialUrlContainer.put(url,target); } } }
    /**
     * 新增初始URL到缓存
     * @param initialUrl
     */
    public static void addInitialUrl(InitialUrl initialUrl){
        initialUrlContainer.put(initialUrl.getUrl(),initialUrl); }

    /**
     * 删除某条URL记录
     * @param initialUrl
     */
    public static void deleteInitialUrl(InitialUrl initialUrl){
        initialUrlContainer.remove(initialUrl.getUrl());
    }
    /**
     * 判断目标URL是否在缓存容器中存在，若存在则返回true
     * @param url
     * @return
     */
    public static boolean contains(String url){
        InitialUrl target = initialUrlContainer.get(url);
        return target == null?false:true; }
}
