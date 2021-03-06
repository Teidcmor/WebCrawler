package coreData.dto;

import java.util.ArrayList;

public class CoreDataDTO {

    /**
     * 主键id
     */
    private long id;
    /**
     * 网页地址内容归属城市
     */
    private String city;
    /**
     * 网页地址内容归属行政区
     */
    private String district;

    /**
     * 网页地址内容所属地区
     */
    private String region;

    /**
     * 网页地址内容归属社(小)区
     */
    private String community;
    /**
     * 面积
     */
    private int area;
    /**
     * 楼层
     */
    private String floor;
    /**
     * 朝向
     */
    private String toward;
    /**
     * 户型
     */
    private String houseModel;
    /**
     * 价格
     */
    private int price;
    /**
     * 其他优惠信息
     */
    private String preference;
    /**
     * 图片地址
     */
    private String pictureUrl;
    /**
     * 图片地址
     */
    private ArrayList<String> pictures;
    /**
     * 其他信息
     */
    private String otherDetails;
    /**
     * 备用字段1
     */
    private String reserve1;
    /**
     * 备用字段2
     */
    private String reserve2;
    /**
     * 备注字段3
     */
    private String reserve3;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getToward() {
        return toward;
    }

    public void setToward(String toward) {
        this.toward = toward;
    }

    public String getHouseModel() {
        return houseModel;
    }

    public void setHouseModel(String houseModel) {
        this.houseModel = houseModel;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        this.setPictures(pictureUrl);
    }

    public ArrayList<String> getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        String[] target = pictures.split(",");
        ArrayList<String > list = new ArrayList<String>();
        for(String str:target){
            list.add(str);
        }
        this.pictures = list;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }

    public String getReserve3() {
        return reserve3;
    }

    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3;
    }
}
