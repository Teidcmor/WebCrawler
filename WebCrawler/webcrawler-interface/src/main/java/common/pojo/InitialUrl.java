package common.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class InitialUrl {

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
     * 网页地址内容归属社(小)区
     */
    private String community;
    /**
     * 超时时长
     */
    private int timeout;
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
}