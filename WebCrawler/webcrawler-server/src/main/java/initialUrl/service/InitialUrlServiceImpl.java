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
        return null;
    }

    /**
     * 查询全部初始url列表
     *
     * @return
     */
    public List<InitialUrl> getAllInitialUrl() {
        return null;
    }

    /**
     * 通过url匹配对应记录
     *
     * @param url
     * @return
     */
    public InitialUrl getInitialUrlByName(String url) {
        return null;
    }

    /**
     * 通过id删除指定记录
     *
     * @param id
     */
    public void deleteUrlById(long id) {

    }

    /**
     * 新增url
     *
     * @param initialUrl
     */
    public void insertUrl(InitialUrl initialUrl) {

    }

    public List<InitialUrl> getInitialUrl(){
        return null;
    }

}
