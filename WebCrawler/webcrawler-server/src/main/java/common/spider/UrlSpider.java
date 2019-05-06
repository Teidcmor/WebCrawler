package common.spider;

import common.pojo.InitialUrl;
import common.utils.SpringContextUtils;
import initialUrl.service.interfaces.InitialUrlService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Iterator;

public class UrlSpider {

    InitialUrlService initialUrlService;
    //当前操作中的URL
    InitialUrl initialUrl;
    //当前操作中的URL的网页返回对象String
    String entity;
    //当前操作中的URL的网页返回对象
    Document document;

    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);


    public UrlSpider(InitialUrl url,String str){
        initialUrl = url;
        entity = str;
        //获取Spring容器，并获取initialUrlService对象
        ApplicationContext applicationContext = SpringContextUtils.getAppContext();
        initialUrlService = (InitialUrlService) applicationContext.getBean("initialUrlService");
        document = Jsoup.parse(entity);
    }

    public void urlSpiderBegin() throws Exception {
        if(notNull()){
            //如果是手动添加的链接，则进行目录爬取。避免目录被多次无意义的爬取，但要求必须手动添加不同城市的链接至少一个
            if("1".equals(initialUrl.getReserve1())) {
                catalogueUrlSpider();
            }else {
                pageUrlSpider();
                contentUrlSpider();
            }
        }

    }

    /**
     * 目录页所有链接，不同页面在针对同一个城市的时候目录是一样的，所以同一个城市爬一次就可以了
     * 这部分是获取更多未爬取的页面
     * 针对手动添加的链接，爬取之后正常，等待队列中删除，并置入历史表
     */
    private void catalogueUrlSpider() throws Exception {
        //提取有意义的链接部分
        ArrayList<Element> topDiv = document.getElementsByAttributeValue("class","dl_lst list area");
        //提取目标信息所在的外层div
        ArrayList<Element> district = topDiv.get(0).select("div.area-ls-wp");
        Iterator districtIterator = district.iterator();
        while (districtIterator.hasNext()){
            Element districtElement = (Element)districtIterator.next();
            //获取districtName
            String districtName = districtElement.select("a[href]").first().text();
            Element element = districtElement.select("div.sub_option_list").first();
            ArrayList<Element>linkList = element.select("a[href]");
            Iterator link = linkList.iterator();
            while (link.hasNext()){
                Element regionElement = (Element) link.next();
                String region = regionElement.text();
                String targetUrl = regionElement.attr("href");
                InitialUrl target = new InitialUrl();
                target.setUrl(targetUrl);
                target.setCity(initialUrl.getCity());
                target.setDistrict(districtName);
                target.setRegion(region);
                initialUrlService.insertUrl(target);
                logger.info("新目录链接保存成功！！！ 位置信息：cityName=+"+initialUrl.getCity()+"districtName="+districtName +"regionName:"+region+"URL="+targetUrl);
            }
        }
    }

    /**
     * 分页内容爬取，蛋壳网的分页使用的是传参数控制内容，可能一样的链接内容不一样，所以这部分必须不断爬取
     * 这部分是获取更多未爬取过的页面
     * 这部分比较特殊，每次爬取过后不置入历史表，但是在等待队列中删除
     */
    private void pageUrlSpider() throws Exception {
        Element topDiv = document.select("div.page").first();
        ArrayList<Element> links = topDiv.select("a[href]");
        Iterator iterator = links.iterator();
        while (iterator.hasNext()){
            Element link = (Element) iterator.next();
            String targetUrl = link.attr("href");
            InitialUrl target = this.addNewUrl(targetUrl);
            //标记reserve2字段为1标识该链接为分页链接，爬取内容后删除但不置入历史表
            target.setReserve2("1");
            initialUrlService.insertUrl(target);
            logger.info("新分页链接保存成功！！！ 位置信息：cityName=+"+initialUrl.getCity()+"districtName="+initialUrl.getDistrict() +"regionName:"+initialUrl.getRegion()+"URL="+targetUrl);
        }
    }

    /**
     * 基础信息链接的爬取，每一个租房信息都会有一个唯一的网页详情去说明信息。
     * 这部分是为了获取基础信息，爬取的是能获取基础信息的链接
     * 这部分处理方式正常，置入历史表同时等待队列中删除
     */
    private void contentUrlSpider() throws Exception {
        ArrayList<Element> links = document.getElementsByAttributeValue("class","lk_more");
        Iterator iterator = links.iterator();
        while(iterator.hasNext()){
            Element link = (Element) iterator.next();
            String targetUrl = link.attr("href");
            InitialUrl target = this.addNewUrl(targetUrl);
            initialUrlService.insertUrl(target);
            logger.info("新基本内容链接保存成功！！！ 位置信息：cityName=+"+initialUrl.getCity()+"districtName="+initialUrl.getDistrict() +"regionName:"+initialUrl.getRegion()+"URL="+targetUrl);
        }
    }

    /**
     * 新增URL
     * @param url
     * @throws Exception
     */
    private InitialUrl addNewUrl(String url){
        InitialUrl addUrl = new InitialUrl();
        addUrl.setUrl(url);
        addUrl.setCity(initialUrl.getCity());
        addUrl.setDistrict(initialUrl.getDistrict());
        addUrl.setRegion(initialUrl.getRegion());
        addUrl.setCommunity(initialUrl.getCommunity());
        addUrl.setReserve1(initialUrl.getReserve1());
        addUrl.setReserve2(initialUrl.getReserve2());
        addUrl.setReserve3(initialUrl.getReserve3());
        return addUrl;
    }

    /**
     * 判断当前类所需要的信息是否都已赋值
     * @return
     */
    private boolean notNull(){
        if(this.entity!=null&&this.initialUrl!=null&&this.initialUrlService!=null)
            return true;
        return false;
    }

}
