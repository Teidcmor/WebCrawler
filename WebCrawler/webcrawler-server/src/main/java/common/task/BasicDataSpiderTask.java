package common.task;

import common.container.SysParamContainerUtils;
import common.mapper.BasicDataMapper;
import common.mapper.CoreDataMapper;
import common.pojo.BasicData;
import common.spider.CoreDataSpider;
import common.utils.CommonUtils;
import common.utils.ConstantUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;

@Component
public class BasicDataSpiderTask {
    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    private BasicDataMapper basicDataMapper;
    String enable;
    @Scheduled(cron = "0 0/10 * * * ?")
    public void test() {
        //获取基础数据处理开关参数，如果关闭，不执行后续操作
        initEnable();
        if("1".equals(enable)){
            ArrayList<BasicData> basicData = (ArrayList<BasicData>) basicDataMapper.getAllBasicData();
            Iterator iterator = basicData.iterator();
            while (iterator.hasNext()){
                initEnable();
                if(!"1".equals(enable)){
                    logger.info("基础信息处理定时任务已关闭！！！！");
                    break;
                }
                BasicData current = (BasicData) iterator.next();
                //将基础信息交给信息处理模块
                try {
                    new CoreDataSpider(current).coreDataSpiderBegin();
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("新增有效信息时出错！！！basicData：ID="+current.getId());
                }
                //在基础信息表中删除当前基础信息
                basicDataMapper.deleteBasicDataById(current.getId());
            }
        }else {
            logger.error("定时任务关闭！！！任务结束！！："+CommonUtils.getCurrentDateAndTime());
        }
    }
    /**
     * 更新基础数据处理开关的值，用于实时控制当前程序
     */
    private void initEnable(){
        enable = SysParamContainerUtils.getParamValueByParamName(ConstantUtils.CORE_DATA_SPIDER);
    }
}
