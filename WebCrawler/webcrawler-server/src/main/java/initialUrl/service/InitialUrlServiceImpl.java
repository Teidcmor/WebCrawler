package initialUrl.service;
import common.mapper.InitialUrlMapper;
import common.pojo.InitialUrl;
import initialUrl.service.interfaces.InitialUrlService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
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
    public InitialUrl getInitialUrlById(long id) {
        InitialUrl target = this.initialUrlMapper.getInitialUrlById(id);
        return target;
    }

    /**
     * 查询全部初始url列表
     *
     * @return
     */
    public List<InitialUrl> getAllInitialUrl() {
        List<InitialUrl> list = this.initialUrlMapper.getAllInitialUrl();
        return list;
    }

    /**
     * 通过url匹配对应记录
     *
     * @param url
     * @return
     */
    public InitialUrl getInitialUrlByName(String url) {
        InitialUrl target = this.initialUrlMapper.getInitialUrlByName(url);
        return target;
    }

    /**
     * 通过id删除指定记录
     *
     * @param id
     */
    public void deleteUrlById(long id) {
        this.initialUrlMapper.deleteUrlById(id);
    }

    /**
     * 新增url
     *
     * @param initialUrl
     */
    public void insertUrl(InitialUrl initialUrl) {
        this.initialUrlMapper.insertUrl(initialUrl);
    }

    /**
     * 获取最初默认的几个url。reserve1字段为1的记录
     * 后续获取的url的reserve1字段为空
     * 这几个url一般为手动添加
     *
     * @return
     */
    public List<InitialUrl> getInitialUrl() {
        List<InitialUrl> list = this.initialUrlMapper.getInitialUrl();
        return list;
    }
}
