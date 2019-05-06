package common.pojo;

public class SysParam {

    /**
     * 主键ID
     */
    private long id;
    /**
     * key
     * 数据库中key为关键字，所以用name
     */
    private String paramName;
    /**
     * value
     */
    private String paramValue;
    /**
     * 更新日期
     */
    private String updateDT;
    /**
     * 更新时间
     */
    private String updateTM;
    /**
     * 备注字段1
     */
    private String reserve1;
    /**
     * 备注字段2
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

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
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
}
