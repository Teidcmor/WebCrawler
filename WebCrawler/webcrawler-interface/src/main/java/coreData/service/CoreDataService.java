package coreData.service;

import common.pojo.CoreData;

import java.util.List;

public interface CoreDataService {

    /**
     * 新增有效信息
     * @param coreData
     */
    void insertCoreData(CoreData coreData) throws Exception;

    /**
     * 通过id删除指定有效信息记录
     * @param id
     */
    void deleteCoreData(long id)  throws Exception;

    /**
     * 获取所有有效信息
     * @return
     */
    List<CoreData> getAllCoreData()  throws Exception;

}
