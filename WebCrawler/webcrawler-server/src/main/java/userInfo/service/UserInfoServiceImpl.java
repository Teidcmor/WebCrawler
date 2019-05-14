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

    /**
     * 通过id获取用户信息
     *
     * @param id
     * @return
     */
    public UserInfo getUserInfoById(long id) {
        UserInfo userInfo = this.userInfoMapper.getUserInfoById(id);
        return userInfo;
    }

    /**
     * 设置用户账号可用
     *
     * @param userInfo 传入的参数中enable字段须先赋值为期望值
     */
    public void setUserEnable(UserInfo userInfo) {
        //查询数据库中当前的状态
        UserInfo target = this.userInfoMapper.getUserInfoById(userInfo.getId());
        if("0".equals(target.getEnabled()))//如果当前状态为不可用，则修改数据库状态
            this.userInfoMapper.setUserStatus(userInfo);
    }

    /**
     * 设置用户账号不可用
     *
     * @param userInfo 传入的参数中enable字段须先赋值为期望值
     */
    public void setUserUnEnable(UserInfo userInfo) {
        //查询数据库中当前的状态
        UserInfo target = this.userInfoMapper.getUserInfoById(userInfo.getId());
        if("1".equals(target.getEnabled()))//如果当前状态为可用，则修改数据库状态
            this.userInfoMapper.setUserStatus(userInfo);
    }

    /**
     * 修改用户密码
     *
     * @param userInfo
     */
    public void updateUserPassword(UserInfo userInfo) {
        this.userInfoMapper.editUserPassword(userInfo);
    }
}
