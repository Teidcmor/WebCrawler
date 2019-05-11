package common.spider;

import common.pojo.BasicData;
import common.pojo.CoreData;
import common.utils.SpringContextUtils;
import coreData.service.CoreDataService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoreDataSpider {

    //当前操作中的基础数据对象
    private BasicData basicData;
    //有效数据service层
    private CoreDataService coreDataService;
    //当前基础数据基础信息对象
    private Document document;
    //目标数据
    private CoreData coreData;

    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public CoreDataSpider(BasicData data){
        this.basicData = data;
        this.coreDataService = (CoreDataService) SpringContextUtils.getAppContext().getBean("coreDataService");
        this.document = Jsoup.parse(data.getBasicData());
        this.coreData = new CoreData();
        this.coreData.setCity(data.getCity());
        this.coreData.setDistrict(data.getDistrict());
        this.coreData.setRegion(data.getRegion());
        this.coreData.setReserve1(data.getReserve1());
    }

    /**
     * 有效数据爬取
     */
    public void coreDataSpiderBegin() throws Exception {
        getPictureUrl();
        getPrice();
        getOtherDetails();
        coreDataService.insertCoreData(coreData);
        logger.info("新增有效信息！位置："+coreData.getCity()+" "+coreData.getDistrict()+" "+coreData.getRegion()+" "+coreData.getCommunity()+" "+coreData.getPrice());
    }

    /**
     * 获取所有的图片链接
     */
    private void getPictureUrl(){
        Element topDiv = document.select("div.carousel-inner").first();
        ArrayList<Element> pictures = topDiv.select("img.img-responsive");
        Iterator iterator = pictures.iterator();
        StringBuilder str = new StringBuilder();
        while (iterator.hasNext()){
            Element current = (Element) iterator.next();
            String target = current.attr("src");
            str.append(","+target);
        }
        String pictureUrls = str.substring(1);
        coreData.setPictureUrl(pictureUrls);

    }

    /**
     * 获取所有的价格信息
     */
    private void getPrice(){
        //使用正则表达式匹配所有的数值，即可匹配房租的金额
        String p = "\\d+";
        Pattern pattern = Pattern.compile(p);
        String price ,preference;
        Element topDiv = document.getElementsByAttributeValue("class","room-price").first();
        if(topDiv==null)
            topDiv = document.getElementsByAttributeValue("class","room-price hot").first();
        if(topDiv!=null) {
            Element priceDiv = topDiv.select("div.room-price-num").first();
            if(priceDiv!=null){
                price = priceDiv.text();
                Matcher matcher = pattern.matcher(price);
                matcher.find();
                coreData.setPrice(matcher.group());
            }
            Element preferenceDiv = topDiv.select("div.room-price-sale").first();
            if(preferenceDiv!=null){
                preference = preferenceDiv.text();
                Matcher matcher = pattern.matcher(preference);
                matcher.find();
                preference = matcher.group();
                if(coreData.getPrice()==null){
                    coreData.setPrice(preference);
                }else
                    coreData.setPreference(preference);
            }
        }
    }

    /**
     * 获取其他信息
     * @return
     */
    private void getOtherDetails(){
        Element topDiv = document.getElementsByAttributeValue("class","room-list-box").first();
        if(topDiv!=null){
            ArrayList<Element> details = topDiv.select("div.room-list");
            Iterator iterator = details.iterator();
            while (iterator.hasNext()){
                Element element = (Element) iterator.next();
                String current = element.text();
                if(current.startsWith("建筑面积：")){
                    String p = "\\d+";
                    Pattern pattern = Pattern.compile(p);
                    Matcher matcher = pattern.matcher(current);
                    matcher.find();
                    coreData.setArea(matcher.group());
                }else if(current.startsWith("户型：")) {
                    String houseModel = current.substring(current.indexOf("：")+1);
                    coreData.setHouseModel(houseModel);
                }else if(current.startsWith("朝向：")) {
                    String toward = current.substring(current.indexOf("：")+1);
                    coreData.setToward(toward);
                }else if(current.startsWith("楼层：")) {
                    String floor =  current.substring(current.indexOf("：")+1);
                    coreData.setFloor(floor);
                }else if(current.startsWith("区域：")) {
                    String target = current.substring(current.indexOf("：")+1).trim();
                    target = target.substring(target.indexOf(" ")).trim();
                    String region = target.substring(0,target.indexOf(" ")).trim();
                    String community = target.substring(target.indexOf(" "),target.lastIndexOf(" ")).trim();
                    coreData.setRegion(region);
                    coreData.setCommunity(community);
                }else if(current.startsWith("地铁：")) {
                    String otherDetails = current.substring(current.indexOf("：")+1);
                    coreData.setOtherDetails(otherDetails);
                }
            }
        }

    }

}
