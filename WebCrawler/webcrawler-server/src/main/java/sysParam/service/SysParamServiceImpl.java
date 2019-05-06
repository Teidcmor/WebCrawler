package sysParam.service;

import common.mapper.SysParamMapper;
import common.pojo.SysParam;
import common.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("sysParamService")
@Transactional
public class SysParamServiceImpl implements SysParamService{

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
     * 开启爬虫程序
     */
    public void setSpiderEnable() {
        SysParam sysParam = new SysParam();
        sysParam.setParamName(ConstantUtils.SPIDER_ENABLE);
        sysParam.setParamValue("1");
        sysParamMapper.updateSysParamByName(sysParam);
    }

    /**
     * 关闭爬虫程序
     */
    public void setSpiderUnEanble() {
        SysParam sysParam = new SysParam();
        sysParam.setParamName(ConstantUtils.SPIDER_ENABLE);
        sysParam.setParamValue("0");
        sysParamMapper.updateSysParamByName(sysParam);
    }

    /**
     * 基础数据处理定时任务生效
     */
    public void setBasicSpiderEnable() {
        SysParam sysParam = new SysParam();
        sysParam.setParamName(ConstantUtils.CORE_DATA_SPIDER);
        sysParam.setParamValue("1");
        sysParamMapper.updateSysParamByName(sysParam);
    }

    /**
     * 基础数据处理定时任务失效
     */
    public void setBasicSpiderUnEnable() {
        SysParam sysParam = new SysParam();
        sysParam.setParamName(ConstantUtils.CORE_DATA_SPIDER);
        sysParam.setParamValue("0");
        sysParamMapper.updateSysParamByName(sysParam);
    }
}
