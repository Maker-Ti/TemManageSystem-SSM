package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;


public interface UserService {
    //查询用户
    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    User getUser(User record);

    int updateByPrimaryKey(User record);

}
