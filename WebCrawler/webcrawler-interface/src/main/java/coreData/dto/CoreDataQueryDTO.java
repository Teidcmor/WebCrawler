package coreData.dto;

public class CoreDataQueryDTO {


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
     * 朝向
     */
    private String toward;
    /**
     * 价格
     */
    private int price;
    /**
     * 排序
     */
    private String sort;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
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



    public String getToward() {
        return toward;
    }

    public void setToward(String toward) {
        this.toward = toward;
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
}
