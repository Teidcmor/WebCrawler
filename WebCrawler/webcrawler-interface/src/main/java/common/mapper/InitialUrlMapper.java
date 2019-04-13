package common.mapper;

import common.pojo.InitialUrl;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface InitialUrlMapper {
    /**
     * 查询全部初始url列表
     * @return
     */
    InitialUrl getInitialUrl(long id);
}
