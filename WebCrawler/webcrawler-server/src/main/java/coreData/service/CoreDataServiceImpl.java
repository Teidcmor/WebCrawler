package coreData.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import common.mapper.CoreDataMapper;
import common.pojo.CoreData;
import coreData.dto.CoreDataDTO;
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
    public PageInfo<CoreData> getCoreDataWithPaging() {
        PageHelper.startPage(1,9);
        ArrayList<CoreData> data = (ArrayList<CoreData>) coreDataMapper.getAllCoreData();
        PageInfo<CoreData> pageInfo = new PageInfo<CoreData>(data);
        return pageInfo;
    }

}
