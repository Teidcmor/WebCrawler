package userInfo.service;

import common.pojo.UserInfo;
import userInfo.dto.UserInfoQueryDTO;

public interface UserInfoService {

    /**
     * 用户登录
     * @param queryDTO
     * @return 成功：true 失败 false
     */
    boolean login(UserInfoQueryDTO queryDTO);

    /**
     * 用户注册
     * @param queryDTO
     * @return 成功：ConstantUtils.SUCCESS
     *          失败：ConstantUtils.REGISTER_FAILED
     */
    String resister(UserInfoQueryDTO queryDTO);

    /**
     * 通过用户名获取用户信息
     * @param userName
     * @return
     */
    public UserInfo getUserInfoByUserName(String userName);

}
