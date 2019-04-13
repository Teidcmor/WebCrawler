package initialUrl.service;
import common.mapper.InitialUrlMapper;
import common.pojo.InitialUrl;
import initialUrl.service.interfaces.InitialUrlService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
@Transactional
public class InitialUrlServiceImpl implements InitialUrlService {

    @Resource
    private InitialUrlMapper initialUrlMapper;


    public String getUrl() {
        InitialUrl initialUrl = this.initialUrlMapper.getInitialUrl(1L);
        return initialUrl.getUrl();
    }
}
