package coreData.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import common.mapper.CoreDataMapper;
import common.pojo.CoreData;
import common.utils.BeanUtils;
import common.utils.ConstantUtils;
import coreData.dto.CoreDataDTO;
import coreData.dto.CoreDataQueryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("coreDataService")
@Transactional
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

    /**
     * 获取分页有效信息
     *
     * @return
     */
    public PageInfo<CoreData> getCoreDataWithPaging(CoreDataQueryDTO queryDTO, int pageNum,String sort) throws Exception {
        CoreData query = BeanUtils.copyObject(queryDTO,CoreData.class);
        PageHelper.startPage(pageNum, ConstantUtils.CORE_DATA_PAGE_SIZE);
        ArrayList<CoreData> data = null;
        if(ConstantUtils.SORT_TYPE_1.equals(sort))//如果sort为1，选择默认排序方式
            data = (ArrayList<CoreData>) coreDataMapper.getCoreDataByPosition(query);
        else if(ConstantUtils.SORT_TYPE_2.equals(sort))//如果sort为2，选择降序排序方式
            data = (ArrayList<CoreData>) coreDataMapper.getCoreDataByPositionSort(query);
        else //选择价格升序方式
            data = (ArrayList<CoreData>) coreDataMapper.getCoreDataByPositionSortDesc(query);
        PageInfo<CoreData> pageInfo = new PageInfo<CoreData>(data);
        return pageInfo;
    }

    /**
     * 查询详细信息
     *
     * @param queryDTO
     * @return
     */
    public CoreData getDetails(CoreDataQueryDTO queryDTO) {
        CoreData target = coreDataMapper.getCoreDataById(queryDTO.getId());
        return target;

    }
}
