package sysParam.service.interfaces;

import common.pojo.SysParam;

import java.util.ArrayList;

public interface SysParamService {

    /**
     * 获取所有系统参数
     * @return
     */
    public ArrayList<SysParam> getAllSysParam();

    /**
     * 通过参数名查询系统参数
     * @param name
     * @return
     */
    public SysParam getSysParamByName(String name);

    /**
     * 开启爬虫程序
     */
    public void  setSpiderEnable();

    /**
     * 关闭爬虫程序
     */
    public void setSpiderUnEanble();

    /**
     * 基础数据处理定时任务生效
     */
    public void setBasicSpiderEnable();

    /**
     * 基础数据处理定时任务失效
     */
    public void setBasicSpiderUnEnable();


}
