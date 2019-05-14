package common.mapper;

import common.pojo.UserInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface UserInfoMapper {

    /**
     * 通过用户名查询用户信息
     * @param userName
     * @return
     */
    UserInfo getUserInfoByUserName(String userName);

    /**
     * 新增用户
     * @param userInfo
     */
    void addUser(UserInfo userInfo);

    /**
     * 通过id获取用户信息
     * @param id
     * @return
     */
    UserInfo getUserInfoById(long id);

    /**
     * 设置用户账号状态
     * 0 - 禁用
     * 0 - 可用
     * @param userInfo
     */
    void setUserStatus(UserInfo userInfo);

    /**
     * 修改用户密码
     * @param userInfo
     */
    void editUserPassword(UserInfo userInfo);

    /**
     * 修改用户性别
     * @param userInfo
     */
    void updateUserSex(UserInfo userInfo);

    /**
     * 查询所有普通用户信息
     * @return
     */
    List<UserInfo> getAllSimpleUser();


}
