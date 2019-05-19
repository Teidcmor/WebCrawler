package sysParam.service;

import common.container.SysParamContainerUtils;
import common.mapper.SysParamMapper;
import common.pojo.SysParam;
import common.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sysParam.service.interfaces.SysParamService;

import java.util.ArrayList;

@Service("sysParamService")
@Transactional
public class SysParamServiceImpl implements SysParamService {

    @Autowired
    private SysParamMapper sysParamMapper;

    /**
     * 获取所有系统参数
     *
     * @return
     */
    public ArrayList<SysParam> getAllSysParam() {
        ArrayList<SysParam> target = sysParamMapper.getAllSysParam();
        return target;
    }

    /**
     * 通过参数名查询系统参数
     *
     * @param name
     * @return
     */
    public SysParam getSysParamByName(String name) {
        SysParam target = sysParamMapper.getSysParamByName(name);
        return target;
    }

    /**
     * 修改系统参数值
     *
     * @param sysParam
     */
    public void updateSysParam(SysParam sysParam) {
        this.sysParamMapper.updateSysParamByName(sysParam);
        SysParamContainerUtils.editSysParam(sysParam);
    }
}
