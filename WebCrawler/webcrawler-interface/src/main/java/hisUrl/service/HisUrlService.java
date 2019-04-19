package hisUrl.service;

import common.pojo.HisUrl;

import java.util.List;

public interface HisUrlService {
    /**
     * 新增历史url信息
     * @param hisUrl
     */
    public void insertHisUrl(HisUrl hisUrl) throws Exception;

    /**
     * 通过id删除历史记录信息
     * @param id
     */
    public void deleteHisUrlById(long id) throws Exception;

    /**
     * 查询全部历史url
     * @return
     */
    public List<HisUrl> getAllHisUrl() throws Exception;

    /**
     * 获取指定url信息
     * @param url
     * @return
     */
    public HisUrl getHisUrlByName(String url) throws Exception;
}
