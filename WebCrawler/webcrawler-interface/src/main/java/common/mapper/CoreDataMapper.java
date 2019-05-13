package common.mapper;

import common.pojo.CoreData;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface CoreDataMapper {

    /**
     * 新增有效信息
     * @param coreData
     */
    void insertCoreData(CoreData coreData);

    /**
     * 通过id删除指定有效信息记录
     * @param id
     */
    void deleteCoreData(long id);

    /**
     * 获取所有有效信息
     * @return
     */
    List<CoreData> getAllCoreData();

    /**
     * 按数据库顺序查询所有记录
     * @param coreData
     * @return
     */
    List<CoreData> getCoreDataByPosition(CoreData coreData);

    /**
     * 按价格升序查询数据库记录
     * @param coreData
     * @return
     */
    List<CoreData> getCoreDataByPositionSort(CoreData coreData);

    /**
     * 按价格降序查询数据库记录
     * @param coreData
     * @return
     */
    List<CoreData> getCoreDataByPositionSortDesc(CoreData coreData);

}
