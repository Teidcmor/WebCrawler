package userInfo.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import common.mapper.UserInfoMapper;
import common.pojo.UserInfo;
import common.utils.BeanUtils;
import common.utils.CommonUtils;
import common.utils.ConstantUtils;
import common.utils.MD5Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import userInfo.dto.UserInfoQueryDTO;
import userInfo.service.interfaces.UserInfoService;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;


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
     * @return
     */
    public String login(UserInfoQueryDTO queryDTO) throws Exception {
        if(queryDTO != null){
            //通过登录信息在数据库中查询记录
            UserInfo target = this.userInfoMapper.getUserInfoByUserName(queryDTO.getUserName());
            if(target == null)//查询结果为空,返回用户名或密码错误
                return ConstantUtils.LOGIN_FAILED;
            if(ConstantUtils.USER_UNENABLE.equals(target.getEnabled()))//账号锁定提示账号已禁用
                return ConstantUtils.LOGIN_FAILED_LOCK;
            if(CommonUtils.stringEquals(target.getPassword(),MD5Utils.convertMD5(queryDTO.getPassword())))//密码匹配则通过,否则返回用户名或密码错误
                return ConstantUtils.SUCCESS;
        }
        return ConstantUtils.LOGIN_FAILED;
    }

    /**
     * 用户注册
     *
     * @param queryDTO
     * @return 成功：ConstantUtils.SUCCESS
     *          失败：ConstantUtils.REGISTER_FAILED
     */
    public String resister(UserInfoQueryDTO queryDTO)  {
        if(queryDTO != null){
            try{
                UserInfo userInfo = BeanUtils.copyObject(queryDTO,UserInfo.class);
                //新创建的用户默认为普通用户
                userInfo.setType(ConstantUtils.USER_TYPE_SIMPLE);
                userInfo.setPassword(MD5Utils.convertMD5(userInfo.getPassword()));
                //默认性别为男性，这里必须有默认值，否则在个人中心页面会报错
                userInfo.setReserve1("1");
                UserInfo target = this.userInfoMapper.getUserInfoByUserName(userInfo.getUserName());
                if(target==null){
                    this.userInfoMapper.addUser(userInfo);
                }else
                    return ConstantUtils.REGISTER_FAILED;
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
        if(ConstantUtils.USER_UNENABLE.equals(target.getEnabled()))//如果当前状态为不可用，则修改数据库状态
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
        if(ConstantUtils.USER_ENABLE.equals(target.getEnabled()))//如果当前状态为可用，则修改数据库状态
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

    /**
     * 修改用户性别
     *
     * @param userInfo
     */
    public void updateUserSex(UserInfo userInfo) {
        this.userInfoMapper.updateUserSex(userInfo);
    }

    /**
     * 查询所有普通用户数据
     *
     * @return
     */
    public PageInfo<UserInfo> getAllSimpleUser(int pageNum) {
        PageHelper.startPage(pageNum,ConstantUtils.USER_PAGE_SIZE);
        ArrayList<UserInfo> list = (ArrayList<UserInfo>) this.userInfoMapper.getAllSimpleUser();
        PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>(list);
        return pageInfo;
    }
}
