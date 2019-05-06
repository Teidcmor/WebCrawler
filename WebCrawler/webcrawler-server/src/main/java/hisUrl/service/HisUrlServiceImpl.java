package hisUrl.service;

import common.mapper.HisUrlMapper;
import common.pojo.HisUrl;
import common.container.HisUrlContainerUtils;
import common.utils.CommonUtils;
import hisUrl.service.interfaces.HisUrlService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("hisUrlService")
@Transactional
public class HisUrlServiceImpl implements HisUrlService {

    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    private HisUrlMapper hisUrlMapper;
    /**
     * 新增历史url信息
     * 先更新数据库，再更新缓存
     * @param hisUrl
     */
    public void insertHisUrl(HisUrl hisUrl) throws Exception {
        if(hisUrl!=null&&!hisUrl.isNull()&&!HisUrlContainerUtils.isContains(hisUrl.getUrl())){
            try{
                //设置爬取时间，这个字段是初始url表中没有的，所以必须手动设置
                hisUrl.setLastDT(CommonUtils.getCurrentDate());
                //新增的URL必须设置默认flag值，不然可能导致重复查询。
                hisUrl.setFlag("0");
                //更新数据库
                this.hisUrlMapper.insertHisUrl(hisUrl);
                //更新缓存
                HisUrlContainerUtils.addHisUrl(hisUrl);
            }catch (Exception e){
                e.printStackTrace();
                logger.error("新增历史url失败！！！",hisUrl.getUrl());
                throw new RuntimeException();
            }
        }

    }

    /**
     * 通过id删除历史记录信息
     * 先更新数据库，再更新缓存
     * @param id
     */
    public void deleteHisUrlById(long id) throws Exception{
        HisUrl hisUrl = this.hisUrlMapper.getHisUrlBuId(id);
        if(hisUrl != null){
            try{
                this.hisUrlMapper.deleteHisUrlById(id);
                HisUrlContainerUtils.deleteHisUrl(hisUrl);
            }catch (Exception e){
                e.printStackTrace();
                logger.error("删除历史URL失败!!!",hisUrl.getUrl());
                throw new RuntimeException();
            }
        }
    }

    /**
     * 查询全部历史url
     *
     * @return
     */
    public List<HisUrl> getAllHisUrl() throws Exception {
        List<HisUrl> list = this.hisUrlMapper.getAllHisUrl();
        return list;
    }

    /**
     * 获取指定url信息
     *
     * @param url
     * @return
     */
    public HisUrl getHisUrlByName(String url) throws Exception{
        HisUrl hisUrl = this.hisUrlMapper.getHisUrlByName(url);
        return hisUrl;
    }

    /**
     * 根据url删除历史表中指定记录
     *
     * @param url
     * @throws Exception
     */
    public void deleteHisUrlBuUrl(String url) throws Exception {
        HisUrl hisUrl = this.hisUrlMapper.getHisUrlByName(url);
        if(hisUrl != null){
            try{
                this.hisUrlMapper.deleteHisUrlById(hisUrl.getId());
                HisUrlContainerUtils.deleteHisUrl(hisUrl);
            }catch (Exception e){
                e.printStackTrace();
                logger.error("删除历史URL失败!!!",hisUrl.getUrl());
                throw new RuntimeException();
            }
        }
    }
}
