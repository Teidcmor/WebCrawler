package coreData.service;

import common.mapper.CoreDataMapper;
import common.pojo.CoreData;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CoreDataServiceImpl implements CoreDataService {


    @Autowired
    private CoreDataMapper coreDataMapper;

    /**
     * 新增有效信息
     *
     * @param coreData
     */
    public void insertCoreData(CoreData coreData) throws Exception{
        this.coreDataMapper.insertCoreData(coreData);
    }

    /**
     * 通过id删除指定有效信息记录
     *
     * @param id
     */
    public void deleteCoreData(long id) throws Exception {
        this.coreDataMapper.deleteCoreData(id);
    }

    /**
     * 获取所有有效信息
     *
     * @return
     */
    public List<CoreData> getAllCoreData() throws Exception{
        List<CoreData> list = this.coreDataMapper.getAllCoreData();
        return list;
    }
}
