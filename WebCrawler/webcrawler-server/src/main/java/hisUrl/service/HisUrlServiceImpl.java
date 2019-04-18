package hisUrl.service;

import common.mapper.HisUrlMapper;
import common.pojo.HisUrl;
import common.utils.HisUrlContainerUtils;
import common.utils.SpringContextUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;
import java.util.List;

public class HisUrlServiceImpl implements HisUrlService {

    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Resource
    private HisUrlMapper hisUrlMapper;
    /**
     * 新增历史url信息
     * 先更新数据库，再更新缓存
     * @param hisUrl
     */
    public void insertHisUrl(HisUrl hisUrl) {
        if(hisUrl!=null&&!hisUrl.isNull()){
            try{
                this.hisUrlMapper.insertHisUrl(hisUrl);
                HisUrlContainerUtils hisUrlContainerUtils = SpringContextUtils.getAppContext().getBean(HisUrlContainerUtils.class);
                hisUrlContainerUtils.addHisUrl(hisUrl);
            }catch (Exception e){
                e.printStackTrace();
                logger.error("新增历史url失败！！！",hisUrl.getUrl());
            }
        }

    }

    /**
     * 通过id删除历史记录信息
     * 先更新数据库，再更新缓存
     * @param id
     */
    public void deleteHisUrlById(long id) {
        HisUrl hisUrl = this.hisUrlMapper.getHusUrlBuId(id);
        if(hisUrl != null){
            try{
                this.hisUrlMapper.deleteHisUrlById(id);
                HisUrlContainerUtils hisUrlContainerUtils = SpringContextUtils.getAppContext().getBean(HisUrlContainerUtils.class);
                hisUrlContainerUtils.deleteHisUrl(hisUrl);
            }catch (Exception e){
                e.printStackTrace();
                logger.error("删除历史URL失败!!!",hisUrl.getUrl());
            }
        }
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
