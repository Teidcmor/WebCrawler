package common.threadPool;

import basicData.service.BasicDataService;
import common.container.HisUrlContainerUtils;
import common.pojo.BasicData;
import common.pojo.HisUrl;
import common.pojo.InitialUrl;
import common.utils.BeanUtils;
import common.utils.CommonUtils;
import hisUrl.service.HisUrlService;
import initialUrl.service.interfaces.InitialUrlService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class InitialUrlThread implements Runnable {

    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    private InitialUrlService initialUrlService;
    @Autowired
    private HisUrlService hisUrlService;
    @Autowired
    private BasicDataService basicDataService;
    /**
     * 目标url，由调用该类的方法传入
     */
    private InitialUrl initialUrl;
    /**
     * 基础数据类，处理目标url后生成
     */
    private BasicData basicData;

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void run() {
        if(this.initialUrl != null){
            try{
                //如果url合法：url字段不为空且不为已经处理过不允许重复爬取类型
                if(this.isUrlLegal()){
                    //调用爬虫方法，获取基础数据
                    this.getBasicData();
                    //保存基础数据到数据库中
                    this.saveBasicData();
                    //将处理过的url对象存入历史url表和缓存中
                    this.makeUrlUnEnable();

                }else {
                    logger.error("url不合法！！跳过爬取！！ ID = ",this.initialUrl.getId(),"URl = ",this.initialUrl.getUrl());
                }
            }catch (Exception e){
                logger.error("爬取异常！！！ ID = ",this.initialUrl.getId(),"URl = ",this.initialUrl.getUrl());
                throw new  RuntimeException();

            }
        }
    }

    /**
     * 判断目标url是否合法
     * @return  如果目标url不为空，且在缓存容器中可以找到，则返回true，否则返回false
     * @throws Exception
     */
    private boolean isUrlLegal() throws Exception{
        return this.initialUrl.getUrl() == null ? false : HisUrlContainerUtils.contains(this.initialUrl.getUrl());
    }

    /**
     * 爬虫程序体。爬取目标链接的内容，获取基本信息体
     */
    private void getBasicData(){

    }

    /**
     * 将基础数据内容保存到数据库中
     */
    private void saveBasicData() throws Exception {
        try{
            this.basicDataService.insertBasicData(this.basicData);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("基础数据保存失败！！！ID = ",this.initialUrl.getId(),"URl = ",this.initialUrl.getUrl());
            throw new RuntimeException();
        }

    }

    /**
     * 将处理过的url放入历史表和缓存中
     */
    private void makeUrlUnEnable(){
        try{
            HisUrl hisUrl = BeanUtils.copyObject(this.initialUrl,HisUrl.class);
            this.hisUrlService.insertHisUrl(hisUrl);
        }catch (Exception e){
            e.printStackTrace();

        }
    }


}
