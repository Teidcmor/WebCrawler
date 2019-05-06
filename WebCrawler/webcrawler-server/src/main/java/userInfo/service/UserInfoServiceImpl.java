package userInfo.service;

import common.mapper.UserInfoMapper;
import common.pojo.UserInfo;
import common.utils.BeanUtils;
import common.utils.CommonUtils;
import common.utils.ConstantUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import userInfo.dto.UserInfoQueryDTO;
import userInfo.service.interfaces.UserInfoService;

import javax.annotation.Resource;


@Service("userInfoService")
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    /**
     * 用户登录
     *
     * @param queryDTO
     * @return 成功：true 失败 false
     */
    public boolean login(UserInfoQueryDTO queryDTO) throws Exception {
        if(queryDTO != null){
            UserInfo target = this.userInfoMapper.getUserInfoByUserName(queryDTO.getUserName());
            if(target == null)
                return false;
            if(CommonUtils.stringEquals(target.getPassword(),queryDTO.getPassword()))
                return true;
        }
        return false;
    }

    /**
     * 用户注册
     *
     * @param queryDTO
     * @return 成功：ConstantUtils.SUCCESS
     *          失败：ConstantUtils.REGISTER_FAILED
     */
    public String resister(UserInfoQueryDTO queryDTO) throws Exception {
        if(queryDTO != null){
            try{
                UserInfo userInfo = BeanUtils.copyObject(queryDTO,UserInfo.class);
                this.userInfoMapper.addUser(userInfo);
            }catch (Exception e){
                logger.error("用户注册失败！",e.getMessage());
                e.printStackTrace();
                return ConstantUtils.REGISTER_FAILED;
            }
            return ConstantUtils.SUCCESS;
        }
        return ConstantUtils.REGISTER_FAILED;
    }

    /**
     * 通过用户名获取用户信息
     *
     * @param userName
     * @return
     */
    public UserInfo getUserInfoByUserName(String userName) throws Exception {
        return this.userInfoMapper.getUserInfoByUserName(userName);
    }
}
