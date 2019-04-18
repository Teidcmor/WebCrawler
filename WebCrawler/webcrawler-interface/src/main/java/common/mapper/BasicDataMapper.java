package common.mapper;

import common.pojo.BasicData;

import java.util.List;

public interface BasicDataMapper {

    /**
     * 新增基础信息
     * @param basicData
     */
    void insertBasicData(BasicData basicData);

    /**
     * 通过id删除基础信息记录
     * @param id
     */
    void deleteBasicDataById(long id);

    /**
     * 查询所有的基础信息
     * @return
     */
    List<BasicData> getAllBasicData();

    /**
     * 查询所有未处理过的基础信息
     * @return
     */
    List<BasicData> getBasicData();

    /**
     * 修改指定id的基础信息
     * @param id
     */
    void setBasicDataUnEnable(long id);

}
