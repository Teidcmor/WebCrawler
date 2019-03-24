package common.mapper;

import common.pojo.initialUrl;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface initialUrlMapper {
    /**
     * 查询全部初始url列表
     * @return
     */
    public ArrayList<initialUrl> getInitialUrl();
}
