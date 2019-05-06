package basicData.service;

import basicData.service.interfaces.BasicDataService;
import common.mapper.BasicDataMapper;
import common.pojo.BasicData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("basicDataService")
@Transactional
public class BasicDataServiceImpl implements BasicDataService {

    @Autowired
    private BasicDataMapper basicDataMapper;

    /**
     * 新增基础信息
     *
     * @param basicData
     */
    public void insertBasicData(BasicData basicData) throws Exception {
        this.basicDataMapper.insertBasicData(basicData);
    }

    /**
     * 通过id删除基础信息记录
     *
     * @param id
     */
    public void deleteBasicDataById(long id) throws Exception {
        this.basicDataMapper.deleteBasicDataById(id);
    }

    /**
     * 查询所有的基础信息
     *
     * @return
     */
    public List<BasicData> getAllBasicData() throws Exception {
        List<BasicData> list = this.basicDataMapper.getAllBasicData();
        return list;
    }

    /**
     * 查询所有未处理过的基础信息
     *
     * @return
     */
    public List<BasicData> getBasicData() throws Exception {
        List<BasicData> list = this.basicDataMapper.getBasicData();
        return list;
    }

    /**
     * 修改指定id的基础信息
     *
     * @param id
     */
    public void setBasicDataUnEnable(long id) throws Exception {
        this.basicDataMapper.setBasicDataUnEnable(id);
    }
}
