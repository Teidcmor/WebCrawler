package initialUrl.service.interfaces;

import common.pojo.InitialUrl;

import java.util.List;

public interface InitialUrlService {

/*    public String getUrl();*/

    /**
     * 通过id查询初始url
     * @return
     */
    InitialUrl getInitialUrlById(long id) throws Exception;

    /**
     *
     * 查询全部初始url列表
     * @return
     */
    List<InitialUrl> getAllInitialUrl() throws Exception;

    /**
     * 获取最初默认的几个url。reserve1字段为1的记录
     * 后续获取的url的reserve1字段为空
     * 这几个url一般为手动添加
     * @return
     */
    List<InitialUrl> getInitialUrl() throws Exception;
    /**
     * 通过url匹配对应记录
     * @param url
     * @return
     */
    InitialUrl getInitialUrlByName(String url) throws Exception;

    /**
     * 通过id删除指定记录
     * @param id
     */
    void deleteUrlById(long id) throws Exception;

    /**
     * 新增url
     * @param initialUrl
     */
    void insertUrl(InitialUrl initialUrl)throws Exception;

}
