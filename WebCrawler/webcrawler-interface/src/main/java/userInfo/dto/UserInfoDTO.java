package userInfo.dto;

public class UserInfoDTO {

    /**
     * 主键id
     */
    private long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户类型
     * 0 ： 普通用户
     * 1 ： 管理用户
     */
    private String type;
    /**
     * 账户是否可用标志
     * 0 ： 不可用
     * 1 ： 可用
     */
    private String enabled;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
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
