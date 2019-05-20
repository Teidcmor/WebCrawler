package common.task;


import common.container.SysParamContainerUtils;
import common.pojo.InitialUrl;
import common.threadPool.InitialUrlThread;
import common.utils.CommonUtils;
import common.utils.ConstantUtils;
import common.utils.ThreadPoolUtils;
import initialUrl.service.interfaces.InitialUrlService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;

@Component
public class InitialUrlSpiderTask {

    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    private InitialUrlService initialUrlService;


    @Scheduled(cron = "0 0/3 * * * ?")
    public void start() throws Exception {
        //如果线程池内没有任务在运行
        if(ThreadPoolUtils.isThreadPoolEmpty()){
            //判断系统参数是否开启
            if(isEnable()){
                doSpider();
            }else {
                logger.info(CommonUtils.getCurrentDateAndTime()+ ConstantUtils.SPIDER_ENABLE+"开关关闭，跳过此次爬取!!");
            }
        }
    }


    private void doSpider() throws Exception {
    ArrayList<InitialUrl> urls = null;
        urls = (ArrayList<InitialUrl>) initialUrlService.getAllInitialUrl();
        Iterator iterator = urls.iterator();
        while(iterator.hasNext()) {
            //每次分配线程之前都判断一下开关是否开启
            if(isEnable()){
                InitialUrl initialUrl = (InitialUrl) iterator.next();
                InitialUrlThread thread = new InitialUrlThread(initialUrl);
                ThreadPoolUtils.getPoolExecutor().submit(thread);
            }
        }
    }

    /**
     * 判断系统参数开关是否打开
     * @return
     */
    private boolean isEnable(){
        String target = SysParamContainerUtils.getParamValueByParamName(ConstantUtils.SPIDER_ENABLE);
        if("1".equals(target))
            return true;
        else
            return false;
    }


}
