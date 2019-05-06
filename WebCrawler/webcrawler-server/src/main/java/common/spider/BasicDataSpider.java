package common.spider;

import basicData.service.BasicDataService;
import common.pojo.BasicData;
import common.pojo.InitialUrl;
import common.utils.SpringContextUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Iterator;

public class BasicDataSpider {

    //当前操作中的URL
    InitialUrl initialUrl;
    //当前操作中的URL的网页返回对象String
    String entity;
    //当前操作中的URL的网页返回对象
    Document document;

    BasicDataService basicDataService;

    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public BasicDataSpider(InitialUrl url,String str){
        this.initialUrl = url;
        this.entity = str;
        this.basicDataService= (BasicDataService) SpringContextUtils.getAppContext().getBean("basicDataService");
        this.document = Jsoup.parse(entity);
    }

    public void basicDataSpiderBegin() throws Exception {
        //获取租房信息所在的外层div
        Element imgDiv = document.select("div.carousel-inner").first();
        Element detailsDic = document.select("div.room-list-box").first();
        if(imgDiv!=null&&detailsDic!=null) {
            String Data = new StringBuilder(imgDiv.toString()).append(detailsDic.toString()).toString();
            BasicData basicData = new BasicData();
            basicData.setCity(initialUrl.getCity());
            basicData.setDistrict(initialUrl.getDistrict());
            basicData.setRegion(initialUrl.getRegion());
            basicData.setCommunity(initialUrl.getCommunity());
            basicData.setBasicData(Data);
            basicDataService.insertBasicData(basicData);
            logger.info("基础保存成功！！！ 位置信息：cityName=+" + initialUrl.getCity() + "districtName=" + initialUrl.getDistrict() + "regionName:" + initialUrl.getRegion());
        }
    }

}
