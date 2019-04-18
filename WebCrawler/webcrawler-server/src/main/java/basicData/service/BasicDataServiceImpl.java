package basicData.service;

import common.mapper.BasicDataMapper;
import common.pojo.BasicData;

import javax.annotation.Resource;
import java.util.List;

public class BasicDataServiceImpl implements BasicDataService {

    @Resource
    private BasicDataMapper basicDataMapper;

    /**
     * 新增基础信息
     *
     * @param basicData
     */
    public void insertBasicData(BasicData basicData) {
        this.basicDataMapper.insertBasicData(basicData);
    }

    /**
     * 通过id删除基础信息记录
     *
     * @param id
     */
    public void deleteBasicDataById(long id) {
        this.basicDataMapper.deleteBasicDataById(id);
    }

    /**
     * 查询所有的基础信息
     *
     * @return
     */
    public List<BasicData> getAllBasicData() {
        List<BasicData> list = this.basicDataMapper.getAllBasicData();
        return list;
    }

    /**
     * 查询所有未处理过的基础信息
     *
     * @return
     */
    public List<BasicData> getBasicData() {
        List<BasicData> list = this.basicDataMapper.getBasicData();
        return list;
    }

    /**
     * 修改指定id的基础信息
     *
     * @param id
     */
    public void setBasicDataUnEnable(long id) {
        this.basicDataMapper.setBasicDataUnEnable(id);
    }
}
