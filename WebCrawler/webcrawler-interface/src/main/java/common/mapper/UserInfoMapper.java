package common.mapper;

import common.pojo.UserInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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



}
