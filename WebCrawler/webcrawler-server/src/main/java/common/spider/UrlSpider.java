package common.spider;

import common.container.InitialUrlContainerUtils;
import common.pojo.HisUrl;
import common.pojo.InitialUrl;
import common.utils.BeanUtils;
import common.utils.SpringContextUtils;
import hisUrl.service.HisUrlService;
import hisUrl.service.HisUrlServiceImpl;
import initialUrl.service.interfaces.InitialUrlService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class UrlSpider {


    public static void urlSpiderBegin(InitialUrl url, String entity) throws Exception {
        Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        //获取Spring容器，并获取initialUrlService对象
        ApplicationContext applicationContext = SpringContextUtils.getAppContext();
        InitialUrlService initialUrlService = (InitialUrlService) applicationContext.getBean("initialUrlService");
        //获取URL返回对象
        Document document = Jsoup.parse(entity);
        //提取有意义的链接部分
        ArrayList<Element> topDiv = document.getElementsByAttributeValue("class","dl_lst list area");
        //todo 翻页部分链接需要添加进来
        String body = topDiv.get(0).toString();
        Document topTarget = Jsoup.parseBodyFragment(body);
        ArrayList<Element> district = topTarget.select("div.area-ls-wp");
        Iterator districtIterator = district.iterator();
        while (districtIterator.hasNext()){
            Element districtElement = (Element)districtIterator.next();
            String districtName = districtElement.select("a[href]").first().text();
            logger.info("获取链接，位置信息"+"districtName:"+districtName);
            Element element = districtElement.select("div.sub_option_list").first();
            ArrayList<Element>linkList = element.select("a[href]");
            Iterator link = linkList.iterator();
            while (link.hasNext()){
                Element regionElement = (Element) link.next();
                String region = regionElement.text();
                logger.info("获取链接，位置信息"+"regionName:"+region);
                String targetUrl = regionElement.attr("href");
                logger.info("获取链接，位置信息"+"URL:"+targetUrl);
                if(!InitialUrlContainerUtils.contains(targetUrl)){
                    InitialUrl target = new InitialUrl();
                    target.setUrl(targetUrl);
                    target.setCity(url.getCity());
                    target.setDistrict(districtName);
                    target.setRegion(region);
                    initialUrlService.insertUrl(target);
                    logger.info("链接保存成功！！！"+"URL:"+targetUrl);
                }
            }
        }
    }
}
