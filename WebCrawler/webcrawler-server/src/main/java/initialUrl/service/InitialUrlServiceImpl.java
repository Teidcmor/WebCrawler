package initialUrl.service;
import com.github.pagehelper.PageHelper;
import common.container.HisUrlContainerUtils;
import common.container.InitialUrlContainerUtils;
import common.mapper.InitialUrlMapper;
import common.pojo.InitialUrl;
import coreData.dto.CoreDataDTO;
import initialUrl.service.interfaces.InitialUrlService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("initialUrlService")
@Transactional
public class InitialUrlServiceImpl implements InitialUrlService {

    @Resource
    private InitialUrlMapper initialUrlMapper;

/*
    public String getUrl() {
        InitialUrl initialUrl = this.initialUrlMapper.getInitialUrl(1L);
        return initialUrl.getUrl();
    }*/

    /**
     * 通过id查询初始url
     *
     * @param id
     * @return
     */
    public InitialUrl getInitialUrlById(long id)  throws Exception{
        InitialUrl target = this.initialUrlMapper.getInitialUrlById(id);
        return target;
    }

    /**
     * 查询全部初始url列表
     *
     * @return
     */
    public List<InitialUrl> getAllInitialUrl()  throws Exception{
        List<InitialUrl> list = this.initialUrlMapper.getAllInitialUrl();
        return list;
    }

    /**
     * 通过url匹配对应记录
     *
     * @param url
     * @return
     */
    public InitialUrl getInitialUrlByName(String url)  throws Exception {
        InitialUrl target = this.initialUrlMapper.getInitialUrlByName(url);
        return target;
    }

    /**
     * 通过id删除指定记录
     *
     * @param initialUrl
     */
    public void deleteUrlById(InitialUrl initialUrl)  throws Exception{
        this.initialUrlMapper.deleteUrlById(initialUrl.getId());
        InitialUrlContainerUtils.deleteInitialUrl(initialUrl);
    }

    /**
     * 新增url
     *
     * @param initialUrl
     */
    public void insertUrl(InitialUrl initialUrl) throws Exception {
        //如果信息的url在初始队里和历史队列里都不存在
        if(initialUrl!=null && !initialUrl.isNull() && !InitialUrlContainerUtils.contains(initialUrl.getUrl())&& !HisUrlContainerUtils.isContains(initialUrl.getUrl())){
            this.initialUrlMapper.insertUrl(initialUrl);
            InitialUrlContainerUtils.addInitialUrl(initialUrl);
        }
    }

    /**
     * 获取最初默认的几个url。reserve1字段为1的记录
     * 后续获取的url的reserve1字段为空
     * 这几个url一般为手动添加
     *
     * @return
     */
    public List<InitialUrl> getInitialUrl() throws Exception {
        List<InitialUrl> list = this.initialUrlMapper.getInitialUrl();
        return list;
    }

    /**
     * 管理员手动添加URL
     *
     * @param initialUrl
     */
    public void addNewUrl(InitialUrl initialUrl) throws Exception {
        initialUrl.setReserve1("1");
        this.insertUrl(initialUrl);
    }
}
