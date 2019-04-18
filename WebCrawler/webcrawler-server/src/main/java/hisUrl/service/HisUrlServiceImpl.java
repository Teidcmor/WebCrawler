package hisUrl.service;

import common.mapper.HisUrlMapper;
import common.pojo.HisUrl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

public class HisUrlServiceImpl implements HisUrlService {

    @Resource
    private HisUrlMapper hisUrlMapper;
    /**
     * 新增历史url信息
     *
     * @param hisUrl
     */
    public void insertHisUrl(HisUrl hisUrl) {
        this.hisUrlMapper.insertHisUrl(hisUrl);
    }

    /**
     * 通过id删除历史记录信息
     *
     * @param id
     */
    public void deleteHisUrlById(long id) {
        this.hisUrlMapper.deleteHisUrlById(id);
    }

    /**
     * 查询全部历史url
     *
     * @return
     */
    public List<HisUrl> getAllHisUrl() {
        List<HisUrl> list = this.hisUrlMapper.getAllHisUrl();
        return list;
    }

    /**
     * 获取指定url信息
     *
     * @param url
     * @return
     */
    public HisUrl getHisUrlByName(String url) {
        HisUrl hisUrl = this.hisUrlMapper.getHisUrlByName(url);
        return hisUrl;
    }
}
