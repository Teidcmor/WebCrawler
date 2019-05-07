package common.mapper;

import common.pojo.SysParam;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
@Repository
@Transactional(propagation = Propagation.REQUIRED)
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
