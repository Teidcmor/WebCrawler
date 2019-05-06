package common.mapper;

import common.pojo.SysParam;

import java.util.ArrayList;

public interface SysParamMapper {

    /**
     * 获取所有系统参数
     * @return
     */
    public ArrayList<SysParam> getAllSysParam();

    /**
     * 通过参数名查询系统参数信息
     * @return
     */
    public SysParam getSysParamByName(String name);

    /**
     * 通过参数名修改系统参数值
     * @param sysParam
     */
    public void updateSysParamByName(SysParam sysParam);


}
