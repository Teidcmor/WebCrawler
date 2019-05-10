package common.threadPool;

import common.container.HisUrlContainerUtils;
import common.pojo.HisUrl;
import common.pojo.InitialUrl;
import common.spider.BasicDataSpider;
import common.spider.UrlSpider;
import common.utils.BeanUtils;
import common.utils.ConstantUtils;
import common.utils.SpringContextUtils;
import hisUrl.service.interfaces.HisUrlService;
import initialUrl.service.interfaces.InitialUrlService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.StandardHttpRequestRetryHandler;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class InitialUrlThread implements Runnable {

    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    private InitialUrlService initialUrlService;

    private HisUrlService hisUrlService;
    /**
     * 目标url，由调用该类的方法传入
     */
    private InitialUrl initialUrl;

    public InitialUrlThread(){}

    public InitialUrlThread(InitialUrl url){
        this.initialUrl = url;
        ApplicationContext applicationContext = SpringContextUtils.getAppContext();
        this.initialUrlService = ((InitialUrlService) applicationContext.getBean("initialUrlService"));
        this.hisUrlService = ((HisUrlService) SpringContextUtils.getAppContext().getBean("hisUrlService"));
    }

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
        //如果没有为这两个对象赋值，后续程序无法运行，直接返回
        if(this.initialUrlService==null||this.hisUrlService==null)
            return;
        if(this.initialUrl != null){
            try{
                //如果url合法：url字段不为空且不为已经处理过不允许重复爬取类型
                if(this.isUrlLegal()){
                    //将处理过的url对象存入历史url表和缓存中
                    //先置入历史表，再做后续爬取操作。防止重复爬取
                    this.makeUrlUnEnable();
                    //调用爬虫方法，获取基础数据
                    this.getBasicData();

                }else {
                    logger.error("url不合法！！跳过爬取！！ ID = "+ this.initialUrl.getId()+"URl = "+this.initialUrl.getUrl());
                    //删除异常url
                    this.initialUrlService.deleteUrlById(this.initialUrl);
                }
            }catch (Exception e){
                logger.error("爬取异常！！！ ID = "+this.initialUrl.getId()+"URl = "+this.initialUrl.getUrl());
                throw new  RuntimeException();

            }
        }
    }

    /**
     * 判断目标url是否合法
     * @return  如果目标url不为空，且在历史缓存容器中可以找不到，则返回true，否则返回false
     * @throws Exception
     */
    private boolean isUrlLegal() throws Exception{
        boolean result = this.initialUrl.getUrl() == null ? false : !HisUrlContainerUtils.contains(this.initialUrl.getUrl());
        return result;
    }

    /**
     * 爬虫程序体。爬取目标链接的内容，获取基本信息体
     * 创建链接，获取对象实体，将实体送入对应模块获取有效信息，将url置入历史表，初始表中删除
     */
    private void getBasicData() throws Exception {
        //如果没有设置超时，则使用默认超时时长
        int timeout = this.initialUrl.getTimeout()==0? ConstantUtils.TIMEOUT:this.initialUrl.getTimeout();
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(timeout)
                .setConnectionRequestTimeout(timeout)
                .setSocketTimeout(timeout).build();//超时设置
        //设置重试，如果是可重试的链接失败，最对重试三次
        HttpRequestRetryHandler retryHandler = new StandardHttpRequestRetryHandler(3,true);
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setRetryHandler(retryHandler)
                .build();//创建请求
        HttpGet httpGet = this.getHttpGet();
        HttpResponse response = null;
        HttpEntity entity = null;
        String target = null;
        try {//创建连接，有可能抛出IO异常
            response = httpClient.execute(httpGet);
            //获取连接状态
            int returnCode = response.getStatusLine().getStatusCode();
            //获取返回实体（页面所有要素）
            entity = response.getEntity();
            if(returnCode==200&&entity!=null){
                logger.info("链接成功，获取返回实体！！ ID = "+this.initialUrl.getId()+"URl = "+this.initialUrl.getUrl());
                //页面实体转string。这里已经成功拿到实体，连接可以释放。把String对象交给后续的模块处理
                target = EntityUtils.toString(entity,"utf-8");
                //开始获取网页中所有有效的链接，加入队列中，提供给后续爬取
                new UrlSpider(this.initialUrl,target).urlSpiderBegin();
                //如果不是手动加入的初始链接，则开始为T_BASIC_DATA表爬取基础信息
                new BasicDataSpider(this.initialUrl,target).basicDataSpiderBegin();
                //获取到返回的对象之后，先将当前url删除
                this.initialUrlService.deleteUrlById(this.initialUrl);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("爬虫连接创建失败！！！ID = "+this.initialUrl.getId()+"URl = "+this.initialUrl.getUrl());
            //如果URL网页实体获取失败，因为前面代码中已经将当前的url置入了历史表，故而需要从历史表中删除
            hisUrlService.deleteHisUrlBuUrl(initialUrl.getUrl());
            throw new RuntimeException();
        } finally {//无论程序是否异常，释放所有连接
            EntityUtils.consume(entity);
            httpGet.releaseConnection();
            httpClient.close();
        }
    }

    /**
     * 将处理过的url放入历史表和缓存中
     */
    private void makeUrlUnEnable(){
        try{
            HisUrl hisUrl = BeanUtils.copyObject(this.initialUrl,HisUrl.class);
            //如果不是分页类的链接，则置入历史表
            if(!"1".equals(initialUrl.getReserve2()))
                this.hisUrlService.insertHisUrl(hisUrl);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * 获取HttpGet对象
     * @return
     */
    private HttpGet getHttpGet(){
        HttpGet httpGet = new HttpGet(this.initialUrl.getUrl());
        httpGet.setHeader("Accept", "Accept text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        httpGet.setHeader("Accept-Charset", "GB2312,utf-8;q=0.7,*;q=0.7");
        httpGet.setHeader("Accept-Encoding", "gzip, deflate");
        httpGet.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
        httpGet.setHeader("Connection", "keep-alive");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36");
        return httpGet;
    }

    public InitialUrlService getInitialUrlService() {
        return initialUrlService;
    }

    public void setInitialUrlService(InitialUrlService initialUrlService) {
        this.initialUrlService = initialUrlService;
    }

    public HisUrlService getHisUrlService() {
        return hisUrlService;
    }

    public void setHisUrlService(HisUrlService hisUrlService) {
        this.hisUrlService = hisUrlService;
    }

    public InitialUrl getInitialUrl() {
        return initialUrl;
    }

}
