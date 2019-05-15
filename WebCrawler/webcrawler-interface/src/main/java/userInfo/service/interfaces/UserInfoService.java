package userInfo.service.interfaces;

import com.github.pagehelper.PageInfo;
import common.pojo.UserInfo;
import userInfo.dto.UserInfoQueryDTO;

import java.util.ArrayList;

public interface UserInfoService {

    /**
     * 用户登录
     * @param queryDTO
     * @return 成功：true 失败 false
     */
    boolean login(UserInfoQueryDTO queryDTO) throws Exception;

    /**
     * 用户注册
     * @param queryDTO
     * @return 成功：ConstantUtils.SUCCESS
     *          失败：ConstantUtils.REGISTER_FAILED
     */
    String resister(UserInfoQueryDTO queryDTO) throws Exception;

    /**
     * 通过用户名获取用户信息
     * @param userName
     * @return
     */
    public UserInfo getUserInfoByUserName(String userName) throws Exception;

    /**
     * 通过id获取用户信息
     * @param id
     * @return
     */
    public UserInfo getUserInfoById(long id);

    /**
     * 设置用户账号可用
     * @param userInfo
     */
    public void setUserEnable(UserInfo userInfo);

    /**
     * 设置用户账号不可用
     * @param userInfo
     */
    public void setUserUnEnable(UserInfo userInfo);

    /**
     * 修改用户密码
     * @param userInfo
     */
    public void updateUserPassword(UserInfo userInfo);

    /**
     * 修改用户性别
     * @param userInfo
     */
    public void updateUserSex(UserInfo userInfo);

    /**
     * 分页查询所有普通用户数据
     * @return
     */
    public PageInfo<UserInfo> getAllSimpleUser(int pageNum);

}
