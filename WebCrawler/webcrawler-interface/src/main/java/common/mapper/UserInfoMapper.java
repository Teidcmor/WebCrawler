package common.mapper;

import common.pojo.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
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



}
