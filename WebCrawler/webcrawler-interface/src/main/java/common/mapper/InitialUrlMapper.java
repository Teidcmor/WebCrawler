package common.mapper;

import common.pojo.InitialUrl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InitialUrlMapper {
    /**
     * 通过id查询初始url
     * @return
     */
    InitialUrl getInitialUrlById(long id);

    /**
     *
     * 查询全部初始url列表
     * @return
     */
    List<InitialUrl> getAllInitialUrl();

    /**
     * 获取最初默认的几个url。reserve1字段为1的记录
     * 后续获取的url的reserve1字段为空
     * 这几个url一般为手动添加
     * @return
     */
    List<InitialUrl> getInitialUrl();
    /**
     * 通过url匹配对应记录
     * @param url
     * @return
     */
    InitialUrl getInitialUrlByName(String url);

    /**
     * 通过id删除指定记录
     * @param id
     */
    void deleteUrlById(long id);

    /**
     * 新增url
     * @param initialUrl
     */
    void insertUrl(InitialUrl initialUrl);

}
