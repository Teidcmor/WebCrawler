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
     * 修改系统参数值
     * @param sysParam
     */
    void updateSysParam(SysParam sysParam);



}
