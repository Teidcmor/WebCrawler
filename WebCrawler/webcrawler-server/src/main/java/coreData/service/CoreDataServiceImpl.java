package coreData.service;

import common.mapper.CoreDataMapper;
import common.pojo.CoreData;

import javax.annotation.Resource;
import java.util.List;

public class CoreDataServiceImpl implements CoreDataService {


    @Resource
    private CoreDataMapper coreDataMapper;

    /**
     * 新增有效信息
     *
     * @param coreData
     */
    public void insertCoreData(CoreData coreData) {
        this.coreDataMapper.insertCoreData(coreData);
    }

    /**
     * 通过id删除指定有效信息记录
     *
     * @param id
     */
    public void deleteCoreData(long id) {
        this.coreDataMapper.deleteCoreData(id);
    }

    /**
     * 获取所有有效信息
     *
     * @return
     */
    public List<CoreData> getAllCoreData() {
        List<CoreData> list = this.coreDataMapper.getAllCoreData();
        return list;
    }
}
