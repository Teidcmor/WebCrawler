package common.pojo;


public class HisUrl {

    /**
     * 主键id
     */
    private long id;
    /**
     * 网页地址url
     */
    private String url;
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
     * 超时时长
     */
    private int timeout;
    /**
     *上次查询日期
     */
    private String lastDT;
    /**
     * 是否可以重复查询标志
     * 0 ： 不允许再次查询此URL的内容
     * 1 ： 允许再次查询
     */
    private String flag;
    /**
     * 更新时间
     */
    private String updateDT;
    /**
     * 更新日期
     */
    private String updateTM;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getLastDT() {
        return lastDT;
    }

    public void setLastDT(String lastDT) {
        this.lastDT = lastDT;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getUpdateDT() {
        return updateDT;
    }

    public void setUpdateDT(String updateDT) {
        this.updateDT = updateDT;
    }

    public String getUpdateTM() {
        return updateTM;
    }

    public void setUpdateTM(String updateTM) {
        this.updateTM = updateTM;
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




    public boolean isNull(){
        if(this.url!=null)
            return false;
        return true;
    }

}
