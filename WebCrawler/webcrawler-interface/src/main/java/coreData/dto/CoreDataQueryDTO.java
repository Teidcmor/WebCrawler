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
    private String area;
    /**
     * 朝向
     */
    private String toward;
    /**
     * 价格
     */
    private String price;

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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getToward() {
        return toward;
    }

    public void setToward(String toward) {
        this.toward = toward;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
